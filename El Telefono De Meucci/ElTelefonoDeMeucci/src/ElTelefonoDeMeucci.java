import java.util.Scanner;

public class ElTelefonoDeMeucci {
    static int tot=0;
    static String fr="";
    static String[] set1 = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    public static void main(String[] args) {
        System.out.println("Escribe tu numero de telefono en numero romanos");
        Scanner t = new Scanner(System.in);
        while(t.hasNext()){
            tot = 0;
            fr=t.next();
            if(!fr.contains("I")&&!fr.contains("V"))
                tot++;
            else
                buscar(fr);
            System.out.println(tot);
        }
    }

    private static void buscar(String f) {
        for(int i=1;i<5&&i<=f.length();i++){
            boolean encontrado=false;
            for(int j=0;j<10;j++){
                if(f.substring(0,i).equals(set1[j]))
                    encontrado=true;
            }
            if(encontrado){
                String res=f.substring(i,f.length());
                if(res.length()>0)
                    buscar(res);
                else if(res.length()==0){
                    tot++;
                    return;
                }
            }
        }
    }
}