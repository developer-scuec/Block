package addCar;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlterCar {
    private Map<Integer, item> map=new LinkedHashMap<>();
    public void add(item i){
        int id=i.getId();
        item isHave=map.get(id);
        if(isHave!=null){
            isHave.setCount(isHave.getCount()+1);
        }else {
            map.put(i.getId(),i);
        }
    }
    public Map<Integer, item> getItem(){
        return this.map;
    }

}
