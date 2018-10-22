package com.agfa.demo.domain.PlantKingdom;

import com.agfa.demo.persistence.PlantEntity;
import com.agfa.demo.persistence.PlantService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class BananaTree extends Plant {

    @Resource
    private PlantService plantService;

    @Override
    public void grow() {
        plantService.updateIfEmpty(this);
        plantService.insert(new Banana());
    }

    @Override
    public Vegetable weedSeed() {
        return new BananaTree();
    }
}
