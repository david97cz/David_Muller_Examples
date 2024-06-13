import numpy as np

def getS(A,B,Q,R,S_k1,N):

    #Matice S - z Riccatiho rovnice
    S_k = Q + A.T @ S_k1 @ A - (A.T @ S_k1 @ B) @ np.linalg.pinv(R + B.T @ S_k1 @ B) @ (B.T @ S_k1 @ A)
    #S_k = Q + A.T @ S_k1 @ A - A.T @ S_k1 @ B
    return S_k

def getK(A,B,R,S):
    #Kalmanovo zesileni K
    K = np.linalg.inv(R + B.T@ S @ B)@B.T @ S @ A
    return K

def lqr_regulator(A,B,Q,R,x0,xn,N,S):
    #incializace
    x =np.zeros(N)
    error=np.zeros(N)
    u =np.zeros(N)
    len_s = np.shape(S)
    S_mat = np.zeros(((N+1),len_s[1]))

    x[0]=x0
    x[5:7]=xn/2
    x[7:10]=xn

    #odchylka od pozadovaneho stavu
    error = x-x0


    for i in range(N, 0, -1):
        S_mat[i-1,:] = getS(A, B, Q, R, S_mat[i],N)

    for i in range (1, N-1):
        K = getK(A,B,R,S)
        #u[i] = -K * x[i]
        u[i] = np.dot(-K[0],x[i])
    return x,u

def main():
    #stavove matice
    A = np.array([[2]])
    B = np.array([[1]])
    #vahove parametry
    Q = np.array([[0.1]])
    R = np.array([[10]])
    #pocatecni odhad S
    S = np.array([[1]])
    #pocatecni stav
    x0 = 0
    #konecny stav
    xN = 1
    
    N = 10

    [x,u]=lqr_regulator(A,B,Q,R,x0,xN,N,S)
    print("prubeh x:\n",x)
    print("prubeh u:\n",u)

main()
