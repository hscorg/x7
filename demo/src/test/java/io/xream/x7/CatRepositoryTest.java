package io.xream.x7;

import io.xream.x7.demo.CatRepository;
import io.xream.x7.demo.bean.Cat;
import io.xream.x7.demo.bean.DogTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import x7.core.bean.condition.RefreshCondition;

@Service
public class CatRepositoryTest {

    @Autowired
    private CatRepository repository;

    public Cat getOne(){
        Cat cat = new Cat();
        cat.setDogId(555);
        cat = this.repository.getOne(cat);

        return cat;
    }

    public Cat get(){
        Cat cat = this.repository.get(1);
        return cat;
    }


    public boolean refresh(){
        RefreshCondition<Cat> refreshCondition = new RefreshCondition<>();
        refreshCondition.refresh("type = 'XXXX'").refresh("taxType","MOON1");
        refreshCondition.and().eq("id",10);
        boolean flag = this.repository.refresh(refreshCondition);
        return flag;
    }

}
