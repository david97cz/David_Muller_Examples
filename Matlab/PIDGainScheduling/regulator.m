%Gain Scheduling
close all
clear all
clc

%interval vzorkovani
T = 0.1; 
%doba simulace
TN = 60; 

%pocet kroku simulace
N = floor(TN/T);

%prubeh vstupu
w =[ones(100,1)*0;ones(300,1)*0.01;ones(200,1)*0];

%kriticka frekvence
wk = sqrt(3)/3;

%konstanty I a D
TI = 0.5*2*pi/wk;
TD = 0.125*2*pi/wk;


% priprava na simulaci
y0=zeros(1,3);
u0=zeros(1,3);
U=zeros(N,1);
Y=zeros(N,1);
R=zeros(N,1);
for k = 1:N
    Bs = [-0.1];
    As = [27 27 9 1]*((u0(1) - 1)^2);

    TFASpoj = tf(Bs,As);
    TFADis = c2d(TFASpoj, T,'zoh');
    [B,A] = tfdata(TFADis,'v');
    
    %gain schedulling
    r0K = -80*(u0(1)-1)^2;
    r0 = 0.6*r0K;
    
    %rovnice regulatoru
    q0 = -r0*(1+T/2/TI+TD/T);
    q1 = r0*(1-T/2/TI+2*TD/T);
    q2 = -r0*TD/T;

    
    %diskretni PID regulator
    u = u0(1)-(q0+q1+q2)*w(k)+[q0 q1 q2]*y0';
    %vystup
    y = (-1).*A(2:4)*y0(1:3)' + B(2:4)*u0(1:3)';
    %aktualizace dat
    y0 = [y,y0(1:end-1)];
    u0 = [u,u0(1:end-1)];
    
    %data pro vizualizaci
    U(k) = u;
    Y(k) = y;
    R(k) = r0;
    
end

t=T:T:N*T;
t=t';
subplot(3,1,1)
plot(t,w,'LineWidth',2);
hold on;
plot(t,Y,'g','LineWidth',2)
hold off;
grid
legend('w - zadana hodnota','y - vystup ze soustavy','Location','Best')
xlabel('cas / s')
title('PID regulator')
subplot(3,1,2)
plot(t,U,'r','LineWidth',2)
grid
xlabel('cas / s')
title('u - vstup do soustavy')
subplot(3,1,3)
plot(t,R,'b','LineWidth',2)
grid
xlabel('cas / s')
title('Zesileni - r0')
