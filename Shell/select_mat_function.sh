#!/bin/bash

echo "Vyberte nastroj"

select nastroj in Fibonacciho_posloupnost Pravouhly_trojuhelnik Matice_soucinu Obsah_kruhu Najdi_c>do
case $nastroj in
        Fibonacciho_posloupnost)
                a=0
                b=1
                arr=($a $b)
                echo "Zvolte pocet iteraci"
                read n
                for (( i = 1; i<=n; i++)); do
                        c=`expr $a + $b`
                        arr+=($c)
                        a=$b
                        b=$c
                        #echo ${arr[@]}
                done
        echo ${arr[@]}
        ;;
        Pravouhly_trojuhelnik)
        echo "zvolte delku odvesny"
        read n
        tri="*\n"
        space=" "
        for ((i=1; i<=n; i++)); do
                space+=$space$space
                tri+="*"$space"*\n"
        done
        tri+=("*")
        echo -e $tri
        ;;
        Matice_soucinu)
        echo "3"
        declare -A matrix
        echo "Zadejte velikost matice"
        read n
        for ((i=1;i<=n;i++));do
                for ((j=1;j<=n;j++));do
                        A[$i,$j]=`echo $i*$j | bc`
                done
        done
        f1="%$((${#n}+1))s"
        f2=" %9s"

        printf "$f1" ''
        for((i=1;i<=n;i++));do
                printf "$f2" $i
        done
        echo

        for ((j=1;j<=n;j++));do
                printf "$f1" $j
                for ((i=1;i<=n;i++));do
                        printf "$f2" ${A[$i,$j]}
                done
                echo
        done
        ;;
         Obsah_kruhu)
        echo "Zvolte polomer: "
        read d
        Obsah () {
                obsah_kruhu=`echo "scale=2;3.14 * ($d * $d) / 4" | bc`
                echo "Obsah kruhu je: "
                return $obsah_kruhu
        }
        Obsah $n
        echo $?
        ;;
        Najdi_cisla)
        echo "5"
        ;;
        Konec)
        break
        ;;
esac
done
