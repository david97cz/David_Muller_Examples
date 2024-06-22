function [Y] = DATA_WHITENING_PCA(D,X)
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


for i = 1:D
        W(i,:)=W(i,:)/sqrt(lambda(i));
end
Y=X*W';
end
