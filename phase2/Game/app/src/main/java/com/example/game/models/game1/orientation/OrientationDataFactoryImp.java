package com.example.game.models.game1.orientation;

public class OrientationDataFactoryImp implements OrientationDataFactory {

    @Override
    public OrientationData makeOrientationDataImp() {
        return new OrientationDataImp();
    }
}
