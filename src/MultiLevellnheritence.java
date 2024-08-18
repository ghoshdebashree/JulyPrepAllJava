public class MultiLevellnheritence {
    public static void main(String[] args){
        Son son = new Son("Saurabh");

        son.setFatherName("Suresh");
        son.setGrandfatherName("Ramesh");
        son.printName();
    }
}

class GrandFather{
    String grandfatherName;
    GrandFather(){

    }
    GrandFather(String grandfatherName){
        this.grandfatherName = grandfatherName;
    }
    String getGrandfatherName(){
        return grandfatherName;
    }
    void setGrandfatherName(String grandfatherName){
        this.grandfatherName = grandfatherName;
    }

}
class Father extends GrandFather{
    String fatherName;
    Father(){

    }
    Father(String fatherName){
        this.fatherName = fatherName;
    }
    String getFatherName(){
        return fatherName;
    }
    void setFatherName(String fatherName){
        this.fatherName = fatherName;
    }
}
class Son extends Father{
    String sonName;
    Son(){

    }
    Son(String sonName){
        this.sonName = sonName;
    }
    public void printName(){
        System.out.println("Son Name  " +sonName );
        System.out.println("Father's name  "+ fatherName);
        System.out.println("GrandFather's name  " +grandfatherName);
    }
}
