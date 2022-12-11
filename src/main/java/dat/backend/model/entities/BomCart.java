package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class BomCart {
    private List<Bom> bomList;

    public BomCart() {
        this.bomList = new ArrayList<>();
    }

    public List<Bom> getBomLines() {
        return bomList;
    }

    public void addToBill(Bom bom) {
        bomList.add(bom);
    }
}