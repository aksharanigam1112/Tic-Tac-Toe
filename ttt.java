import java.util.*;
class ttt
{
    char arr[][] = new char [3][3];
    String p1 , p2;
    char ch = 'X';
     private void initializeBoard() 
     {
         for (int i = 0; i < 3; i++) 
         {
             for (int j = 0; j < 3; j++) 
             {
                arr[i][j] = ' ';
            }
        }
    }

    private void displayBoard()
    {
        for (int i = 0; i < 3; i++) 
         {
             for (int j = 0; j < 3; j++) 
             {
                 System.out.print(arr[i][j]+" | ");
            }
            System.out.print("\n ------------------\n");
        }
    }
    
    private boolean isBoardFull()
    {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) 
        {
            for (int j = 0; j < 3; j++)
            {
                if (arr[i][j] == ' ')
                {
                    isFull = false;
                }
            }
        }
        return isFull;
    }
    
    private boolean check(char ch1 , char ch2 , char ch3)
    {
        if(ch1!=' '&& ch1==ch2 && ch2==ch3)
            return true;
        else
            return false;
        }
        
    private boolean RowWin()
    {
        int i , j;
        for(i=0;i<3;i++)
        {
            if( check(arr[i][0] ,arr[i][1] , arr[i][2])==true)
                    return true;
                }
        return false;
    }
    
    private boolean ColumnWin()
    {
        int i , j;
        for(i=0;i<3;i++)
        {
            if( check(arr[0][i] ,arr[1][i] , arr[2][i])==true)
                    return true;
                }
        return false;
    }
    
    private boolean DiagonalWin()
    {
            if( (check(arr[0][0] ,arr[1][1] , arr[2][2])==true)||(check(arr[0][2] ,arr[1][1] , arr[2][0])==true ))
                    return true;
            else
                    return false;
    }
    
    private void changeplayer()
    {
        if(ch == 'X')
                ch='O';
        else
                ch='X';
            }
            
    public void main()
    {
        Scanner sc = new Scanner(System.in);
        int r , c;
        System.out.println("Enter name of Player1");
        p1 = sc.nextLine();
        System.out.println("Enter name of Player2");
        p2 = sc.nextLine();
        String current_player=p1;
        initializeBoard();
        displayBoard();
        while(isBoardFull() == false && RowWin()==false && ColumnWin()==false && DiagonalWin()==false )
        {
                System.out.println("\n Enter Row ");
                 r = sc.nextInt();
                 System.out.println("\n Enter Column ");
                 c = sc.nextInt();
                 
               if ((r >= 0) && (r < 3)&& (c >= 0) && (c < 3))
                {
                    if(arr[r][c]==' ')
                        arr[r][c] = ch;
                    else
                        {
                            System.out.println("\t\n RETRY! ");
                            System.out.println("\n Enter Row ");
                            r = sc.nextInt();
                            System.out.println("\n Enter Column ");
                            c = sc.nextInt();
                            arr[r][c] = ch;
                    }
                }
               else
                    {
                        System.out.println("\t\n RETRY! ");
                            System.out.println("\n Enter Row ");
                            r = sc.nextInt();
                            System.out.println("\n Enter Column ");
                            c = sc.nextInt();
                            arr[r][c] = ch;
                        }
               displayBoard(); 
               changeplayer();
               if(current_player==p1)
                        current_player=p2;
               else
                        current_player=p1;
                        
                    }
        if(current_player==p1)
                        current_player=p2;
               else
                        current_player=p1;
                                    
        if(RowWin()==true || ColumnWin()==true ||DiagonalWin()==true)
                System.out.print("\n The winner is:- "+current_player);
        else
                System.out.println("Its a tie");

    }
}
    
            
             
