package be.pxl.h8.oef2;

import java.util.ArrayList;

public class Spel {
    private ArrayList<ZeeObject> zeeObjecten = new ArrayList<>();

    public void voegZeeObjectToe(ZeeObject object) {
        zeeObjecten.add(object);
    }

    public void beweegZeeObject(int index, Punt punt) {
        if (zeeObjecten.get(index) instanceof Beweegbaar) {
            ((Beweegbaar) zeeObjecten.get(index)).beweegNaar(punt);
        }
    }

    public int getAantalZeeObjecten() {
        return zeeObjecten.size();
    }

    public void vuur() {
        for (ZeeObject zeeObject : zeeObjecten) {
            if (zeeObject instanceof  GewapendeBoei gewapendeBoei) {
                for (ZeeObject doelwit : zeeObjecten) {
                    gewapendeBoei.doeSchade(doelwit);
                }
            }
        }
    }

    public void printStatus() {
        for (ZeeObject zeeObject: zeeObjecten) {
            System.out.println(zeeObject);
        }
    }


}
