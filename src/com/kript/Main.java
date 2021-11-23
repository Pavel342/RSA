package com.kript;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите ключи");
        Scanner in=new Scanner(System.in);
        int p=in.nextInt();//7
        int q=in.nextInt();//13
        char[] alph={'§','а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
	    System.out.println("Введите секретное сообщение");
        Scanner it=new Scanner(System.in);
        String vvod=it.nextLine();
        int[] vvodInt=new int[vvod.length()];
        int[] enctypt=new int[vvod.length()];
        int n=p*q;//91
        int nnn=(p-1)*(q-1);//72
        int e;
        String otv="";
        for(int i=0;i<vvod.length();i++){
            for(int o=0;o<33;o++) {
                if (vvod.charAt(i) ==alph[o]){vvodInt[i]=o;break;}
            }
        }
        int[] decript=new int[vvod.length()];
        boolean flag;
        do {
            flag=true;
            System.out.println("Введите взаимнопростое");
            e = in.nextInt();
            for (int i = 2; i <= e; i++)
                if (e % i == 0 && nnn % i == 0) {
                    flag = false;
                    break;
                }
        }while(!flag);
        int d;
        d=(nnn+1)/e;
        for(int i=0;i<vvodInt.length;i++){
            enctypt[i]= (int) ((Math.pow( vvodInt[i],d))%n);
        }
        System.out.println("Зашифрованные:");

        for (int j : enctypt) {
            System.out.print(j + " ");
        }
        System.out.println("Расшифрованные:");
        System.out.println(" ");
        for(int i=0;i<vvodInt.length;i++){
            decript[i]= (int) ((Math.pow(enctypt[i], e))%n);
        }
        for (int i = 0; i < enctypt.length; i++) {
            System.out.print(decript[i]+" ");
        }
        System.out.println(" ");
        for (int j : decript) {
            otv += alph[j];
        }
        System.out.println(otv);
        System.out.println("\nОткрытые ключи: " + d + " "+ n);
        System.out.println("Закрытые ключи: "+ e+" "+ n);
    }
}
