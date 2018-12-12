package addCar;

public class item {
    private int id;
    private String url;
    private String name;
    private int price;
    private int count;
    public item(int id,String url,String name,int price,int count){
        this.id=id;
        this.url=url;
        this.name=name;
        this.price=price;
        this.count=count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId(){
        return this.id;
    }
    public String getUrl(){
        return this.url;
    }
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public int getCount(){
        return this.count;
    }
}
