close
clear
clc
%blood preassure
load iris_dataset.mat
X = x'
% X = [126 78;
%     128 80;
%     128 82;
%     130 82;
%     130 84;
%     132 86];
D = 2;
m=size(X,1);
t_x=mean(X,1);

[Y,t,W,eff,eigvec_Y,eigval_Y,EigVecMat,...
    EigValMat] = MY_PCA(X,D);

Y_whitening = DATA_WHITENING_PCA(D,X)

%idx = dbscan(Y_whitening,0.24,D+2);

idx = dbscan(Y_whitening,0.6,D);
nout = sum(idx==-1)
nclass = max(idx)


%K-th Nearest Neigbour
% y_star = [ones(50,1);
%      2*ones(50,1);
%      3*ones(50,1)];
% p =2;
% k =2;
% x_to_class = [1,1]
% y_KNN = KNN_PCA(x_to_class,X,y_star,p,k)

%validace
%y_new = LEAVE1OUT_PCA(X,y_star,k,p);

%T = CONTINGTAB(y_star,y_new)
%[sestar,acc,se] = QUANTY(T)

%[GrM] = KERNEL_PCA(X)


figure(1)
    subplot(3,2,1)
        plot(X(:,1),X(:,2),"ko")
        title("X")
        
    subplot(3,2,2)
        plot(Y(:,1),Y(:,2),"ko")
        title("Y")
    subplot(3,2,3)
        plot(Y_whitening(:,1),Y_whitening(:,2),"ko")
        title("Y-whitening")
    subplot(3,2,4)
        X=X-repmat(t_x,m,1);
        plot(X(:,1),X(:,2),"ko")
        hold on
        plot([0 EigVecMat(1)*6],[0 EigVecMat(2)*6])
        hold on
        plot([0 EigVecMat(3)*6],[0 EigVecMat(4)*6])
        hold off
        title("centered X with 1st component")
    subplot(3,2,5)
        plot(Y(:,1),Y(:,2),"ko")
        hold on
        plot([0 EigVecMat(1)*6],[0 EigVecMat(2)*6])
        hold on
        plot([0 EigVecMat(3)*6],[0 EigVecMat(4)*6])
        hold off
        title("Y with 1st component")
