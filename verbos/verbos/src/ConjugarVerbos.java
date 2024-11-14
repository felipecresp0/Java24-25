import java.util.Scanner;

public class ConjugarVerbos {

    public static void main(String[] args) {
        Scanner t=new Scanner(System.in);
        String[][] a=new String[18][3];
        a[0][0]="o";
        a[1][0]="as";
        a[2][0]="a";
        a[3][0]="amos";
        a[4][0]="ais";
        a[5][0]="an";
        a[6][0]="o";
        a[7][0]="es";
        a[8][0]="e";
        a[9][0]="emos";
        a[10][0]="eis";
        a[11][0]="en";
        a[12][0]="o";
        a[13][0]="es";
        a[14][0]="e";
        a[15][0]="imos";
        a[16][0]="is";
        a[17][0]="en";
        a[0][1]="e";
        a[1][1]="aste";
        a[2][1]="o";
        a[3][1]="amos";
        a[4][1]="asteis";
        a[5][1]="aron";
        a[6][1]="i";
        a[7][1]="iste";
        a[8][1]="io";
        a[9][1]="imos";
        a[10][1]="isteis";
        a[11][1]="ieron";
        a[12][1]="i";
        a[13][1]="iste";
        a[14][1]="io";
        a[15][1]="imos";
        a[16][1]="isteis";
        a[17][1]="ieron";
        a[0][2]="are";
        a[1][2]="aras";
        a[2][2]="ara";
        a[3][2]="aremos";
        a[4][2]="areis";
        a[5][2]="aran";
        a[6][2]="ere";
        a[7][2]="eras";
        a[8][2]="era";
        a[9][2]="eremos";
        a[10][2]="ereis";
        a[11][2]="eran";
        a[12][2]="ire";
        a[13][2]="iras";
        a[14][2]="ira";
        a[15][2]="iremos";
        a[16][2]="ireis";
        a[17][2]="iran";
        String[] b=new String[6];
        b[0]="yo";
        b[1]="tu";
        b[2]="el";
        b[3]="nosotros";
        b[4]="vosotros";
        b[5]="ellos";


        String verbo=t.next();
        String conj=t.next();
        t.nextLine();
        while(!conj.equals("T")){

            String con=verbo.substring(verbo.length()-2, verbo.length());
            verbo=verbo.substring(0, verbo.length()-2);
            if(con.equals("ar")){
                switch(conj){
                    case "A":
                        for(int i=0;i<6;i++){
                            System.out.println(b[i]+" "+verbo+a[i][0]);
                        }
                        break;
                    case "P":
                        for(int i=0;i<6;i++){
                            System.out.println(b[i]+" "+verbo+a[i][1]);
                        }
                        break;
                    case "F":
                        for(int i=0;i<6;i++){
                            System.out.println(b[i]+" "+verbo+a[i][2]);
                        }
                        break;
                    default:
                        break;
                }
            }else if(con.equals("er")){
                switch(conj){
                    case "A":
                        for(int i=6;i<12;i++){
                            System.out.println(b[i-6]+" "+verbo+a[i][0]);
                        }
                        break;
                    case "P":
                        for(int i=6;i<12;i++){
                            System.out.println(b[i-6]+" "+verbo+a[i][1]);
                        }
                        break;
                    case "F":
                        for(int i=6;i<12;i++){
                            System.out.println(b[i-6]+" "+verbo+a[i][2]);
                        }
                        break;
                    default:
                        break;
                }
            }else if(con.equals("ir")){
                switch(conj){
                    case "A":
                        for(int i=12;i<18;i++){
                            System.out.println(b[i-12]+" "+verbo+a[i][0]);
                        }
                        break;
                    case "P":
                        for(int i=12;i<18;i++){
                            System.out.println(b[i-12]+" "+verbo+a[i][1]);
                        }
                        break;
                    case "F":
                        for(int i=12;i<18;i++){
                            System.out.println(b[i-12]+" "+verbo+a[i][2]);
                        }
                        break;
                    default:
                        break;
                }
            }
            verbo=t.next();
            conj=t.next();
            t.nextLine();
        }
    }}