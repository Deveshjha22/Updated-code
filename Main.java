package com.company;
import java.util.*;

class CreditCard
{
    public long cardNo;
    public String cardName;
    public int cvv;

    CreditCard(long cardNo, String cardName, int cvv)
    {
        this.cardNo= cardNo;
        this.cardName= cardName;
        this.cvv= cvv;

    }
    public String toString()
    {
        return cardNo + " " +cardName+ " " + cvv;
    }
}
class Main
{

    public static void main(String[] args) {
        List<CreditCard> c = new ArrayList<CreditCard>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        int ch;
        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("enter your choice");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter cardNo:");
                    long cardNo = s.nextLong();
                    System.out.print("Enter cardName:");
                    String cardName = s1.nextLine();
                    System.out.print("cvv:");
                    int cvv = s.nextInt();
                    c.add(new CreditCard(cardNo, cardName, cvv));
                    break;
                case 2:
                    System.out.println("--------------");
                    Iterator<CreditCard> i = c.iterator();
                    while (i.hasNext()) {
                        CreditCard cc = i.next();
                        System.out.println(cc);
                    }
                    System.out.println("-----------");
                    break;
                case 3:
                    Boolean found = false;
                    System.out.println("Enter cardNo to search:");
                    cardNo = s.nextLong();
                    System.out.println("--------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        CreditCard cc = i.next();
                        if (cc.cardNo == cardNo) {
                            System.out.println(cc);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("record not found");
                    }
                    System.out.println("-----------");
                    break;

                case 4:
                    found = false;
                    System.out.println("Enter cardNo to delete:");
                    cardNo = s.nextLong();
                    System.out.println("--------------");
                    i = c.iterator();
                    while (i.hasNext()) {
                        CreditCard cc = i.next();
                        if (cc.cardNo == cardNo) {
                            i.remove();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("record not found");
                    } else {
                        System.out.println("record is deleted successfully");
                    }
                    System.out.println("-----------");
                    break;

                case 5:
                    found = false;
                    System.out.println("Enter cardNo to update:");
                    cardNo = s.nextLong();
                    System.out.println("--------------");
                    ListIterator<CreditCard> li = c.listIterator();
                    while (li.hasNext()) {
                        CreditCard cc = li.next();
                        if (cc.cardNo == cardNo) {
                            System.out.println("Enter new name:");
                            cardName = s1.nextLine();
                            System.out.println("Enter new cvv");
                            cvv = s.nextInt();
                            li.set(new CreditCard(cardNo, cardName, cvv));
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("record not found");
                    } else {
                        System.out.println("record is updated successfully");
                    }
                    System.out.println("-----------");
                    break;
            }
        }while(ch!=0);
    }
}
