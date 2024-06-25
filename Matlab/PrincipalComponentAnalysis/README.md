## Example of Principal Component Analysis in Matlab

1) Centering the data set

```m
X=X-repmat(t,m,1);
```
   
2) Find the covariance matrix

```m
CovMat=X'*X/(m-1)
```

4) Find the eigenvectors and eigenvalues of the covariance matrix

```m
[EigVecMat,EigValMat]=eig(CovMat)
```

6) Project the data onto the new basis

```m
Y=X*W'
```

8) Data Whitening

```m
for i = 1:D
        W(i,:)=W(i,:)/sqrt(lambda(i));
end
```
