close
clear
clc
%blood preassure
load iris_dataset.mat
X = x'

D = 2;
m=size(X,1);
t_x=mean(X,1);

%PCA
[Y,t,W,eff,eigvec_Y,eigval_Y,EigVecMat,EigValMat] = MY_PCA(X,D);

%whitening
Y_whitening = DATA_WHITENING_PCA(D,X)

%rozděleni do trid pomoci DBscan
idx = dbscan(Y_whitening,0.48,D+1);
nout = sum(idx==-1)
nclass = max(idx)

set_index_outlayer = RETURN_INDEX_CLUSTER(Y_whitening,idx,-1);
set_index_1 = RETURN_INDEX_CLUSTER(Y_whitening,idx,1);
set_index_2 = RETURN_INDEX_CLUSTER(Y_whitening,idx,2);
set_index_3 = RETURN_INDEX_CLUSTER(Y_whitening,idx,3);

%Vykresleni grafu
figure(1)
    subplot(2,2,1)
        plot(X(:,1),X(:,2),"ko")
        title("Input Data")
    subplot(2,2,2)
        plot(Y(:,1),Y(:,2),"ko")
        title("Data after PCA")
    subplot(2,2,3)
        plot(Y_whitening(:,1),Y_whitening(:,2),"ko")
        title("Data after whitening")
    subplot(2,2,4)
        plot(Y(:,1),Y(:,2),"ko")
        hold on
        plot([0 EigVecMat(1)*6],[0 EigVecMat(2)*6])
        hold on
        plot([0 EigVecMat(3)*6],[0 EigVecMat(4)*6])
        hold off
        legend("Data","1st component","2nd component")
        title("1st and 2nd component")
figure(2)
        plot(Y(set_index_1,1),Y(set_index_1,2),"r+")
        hold on
        plot(Y(set_index_2,1),Y(set_index_2,2),"b+")
        hold on
        plot(Y(set_index_3,1),Y(set_index_3,2),"m+")
        hold on
        plot(Y(set_index_outlayer,1),Y(set_index_outlayer,2),"ko")
        hold off
        legend("class 1","class 2","class 3","outlayer")
        title("Clustering")
