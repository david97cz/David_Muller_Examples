function [Y,t,W,eff,eigvec_Y,eigval_Y,EigVecMat,EigValMat] = MY_PCA(X,D)
%Y...komponenty
%t...teziste
%W...matice vektoru vah komponent - faktory
%eff...efektivita
%X...data
%D...pocet komponent

m=size(X,1);
t=mean(X,1);

% 1) vycentrovani X
X=X-repmat(t,m,1);
t=t';

% 2) kovariancni matice
CovMat=X'*X/(m-1);

% 3) vlastni cisla (L) a vektory (V)
[EigVecMat,EigValMat]=eig(CovMat);
lambda = diag(EigValMat);
% 3a) serazeni
[lambda,ind]=sort(lambda,"descend");
EigVecMat=EigVecMat(:,ind);
s=cumsum(lambda);

% 4) efektivita
eff = s(1:D)/s(end);

% 5) PCA
EigVecMat=EigVecMat(:,1:D);
W=EigVecMat';

Y=X*W';
m_Y=size(Y,1);
C_Y=Y'*Y/(m_Y-1);
[eigvec_Y,eigval_Y]=eig(C_Y);
end