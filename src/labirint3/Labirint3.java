package labirint3;
import java.io.*;
public class Labirint3 {
    public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int m,n,i,j,k,d=0,h=1;
      System.out.print("Введите количество строк:");
      m=Integer.parseInt(br.readLine ());
      System.out.print("Введите количество столбцов:");
      n=Integer.parseInt(br.readLine ());
      int [][] l=new int[m][n];
      for (i=0;i<m;i++) 
          for (j=0;j<n;j++){
              System.out.print("("+(i+1)+","+(j+1)+")=");
              l[i][j]=Integer.parseInt(br.readLine ());
          }   
      System.out.print("k=");
      k=Integer.parseInt(br.readLine ());
      for (i=0;i<m;i++) {
          for (j=0;j<n;j++){
              System.out.print(l[i][j]+" ");
          }  
          System.out.println();
     }
      int [][] s=new int[m][n];
      for (i=0;i<m;i++) for (j=0;j<n;j++) s[i][j]=-1;
      s[0][0]=d;
      while(s[m-1][n-1]==-1&&h>0){
          h=0;
      for (i=0;i<m;i++){
          for(j=0;j<n;j++){
            if (s[i][j]==d){
              if (i!=0&&Math.abs(l[i][j]-l[i-1][j])<=k&&s[i-1][j]==-1) {s[i-1][j]=d+1; h++; }//вверх
              if (j!=0&&Math.abs(l[i][j]-l[i][j-1])<=k&&s[i][j-1]==-1) {s[i][j-1]=d+1;h++; }//влево
              if (i!=m-1&&Math.abs(l[i][j]-l[i+1][j])<=k&&s[i+1][j]==-1) {s[i+1][j]=d+1; h++;}//вниз
              if (j!=n-1&&Math.abs(l[i][j]-l[i][j+1])<=k&&s[i][j+1]==-1) {s[i][j+1]=d+1;h++; }//вправо
            }
          }
      }
            d++;  
      }
      if (s[m-1][n-1]==-1) System.out.print("Пути нет");
      else{
          String [] p=new String[d];
          i=m-1;j=n-1;k=d;
          while (d>0){
              if (i!=0&&s[i-1][j]==d-1) {
                  p[d-1]="вниз";i--;
              }
              else{
                if (j!=0&&s[i][j-1]==d-1) {
                    p[d-1]="вправо";j--;
                }
                else{
                if (i!=m-1&&s[i+1][j]==d-1) {
                    p[d-1]="вверх";i++;
                }else {
                if (j!=n-1&&s[i][j+1]==d-1) {
                    p[d-1]="влево";j++;
                } 
               }
              }
              }
              d--;
          }
          for(i=0;i<k;i++) System.out.print(p[i]+" ");
      }     
    }    
}