package dat.backend.model.services;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bom;
import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;

public class Calculator {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    //Beregn stolper
    public Bom calculatePosts(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(11, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Stolpe nedgraves 90 cm. i jord";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfPosts = 300;
        int quantity = 4;
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfPosts, price, quantity);
        return bom;
//        return new Bom(materialId, definition, description, unit, lengthOfPosts, price, quantity);
    }

    //Beregn remme
    public Bom calcualteStraps(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(9, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Remme i sider, sædles ned i stolper";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfStraps = 600;
        int quantity = 2;
        if (lengthOfStraps > 600) {
            quantity += 1;
        }
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfStraps, price, quantity);
        return bom;
    }

    //Beregn spær
    public Bom calculateRafters(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(10, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Spær, monteres på rem";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfRafters = width;
        //Beregner antal spær
        double numberOfRafter = Math.ceil(length / 55.0);
        double endRafter = numberOfRafter + 1;
        int quantity = (int) endRafter;
        //Beregner pris for spær
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfRafters, price, quantity);
        return bom;
    }

    //Beregn understernbrædder til for og bag ende
    public Bom calculateUndersternBoardsFrontAndBack(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(5, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Understernbrædder til for og bag ende";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfUnderstern = width/2;
        int quantity = 4;
        double price = (lengthOfUnderstern/100) * quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfUnderstern, price, quantity);
        return bom;
    }

    //Beregn understernbrædder til sider
    public Bom calculateUndersternBoardsSides(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(6, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Understernbrædder til sider";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfUnderstern = 540;
        int quantity = 2;
        if(lengthOfUnderstern > 540){
            quantity += 2;
        }
        double price = (lengthOfUnderstern/100) * quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfUnderstern, price, quantity);
        return bom;
    }

    //Beregn oversternbrædder til forenden
    public Bom calculateOversternBoardsFront(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(7, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Oversternbrædder til forenden";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfOverstern = width/2;
        int quantity = 2;
        double price = (lengthOfOverstern/100) * quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfOverstern, price, quantity);
        return bom;
    }

    //Beregn oversternbrædder til siderne
    public Bom calculateOversternBoardsSides(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(8, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Oversternbrædder til siderne";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfOverstern = 540;
        int quantity = 2;
        if(lengthOfOverstern > 540){
            quantity += 2;
        }
        double price = (lengthOfOverstern/100) * quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfOverstern, price, quantity);
        return bom;
    }

    //Beregn vandbrædt til siderne
    public Bom calculateWaterBoardSides(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(12, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Vandbrædt på stern i sider";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfWaterBoard = 540;
        int quantity = 2;
        if(lengthOfWaterBoard > 540){
            quantity += 2;
        }
        double price = (lengthOfWaterBoard/100) * quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfWaterBoard, price, quantity);
        return bom;
    }

    //Beregn vandbrædt til forenden
    public Bom calculateWaterBoardFront(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(13, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Vandbrædt på stern i forenden";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfWaterBoard = width/2;
        int quantity = 2;
        double price = (lengthOfWaterBoard/100) * quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfWaterBoard, price, quantity);
        return bom;
    }

    //Beregn tagplader
    public Bom calculateRoofPlates(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(14, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Tagplader monteres på spær";
        String description = material.getDescription();
        String unit = material.getUnit();
        int lengthOfRoofPlates = 600;
        double totalWidthOfRoofPlates = (double) width;
        double amountOfRoofPlates = totalWidthOfRoofPlates / 109;
        int quantity = (int) Math.ceil(amountOfRoofPlates);
        if(length > lengthOfRoofPlates){
            quantity *= 2;
        }
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, lengthOfRoofPlates, price, quantity);
        return bom;
    }

    //Beregn bundskruer
    public Bom calculateBottomScrews(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(15, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Skruer til tagplader";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = 2;
        if(length > 600 || width > 600){
            quantity += 1;
        }
        double price = quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }

    //Beregn hulbånd
    public Bom calculateHulband(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(16, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Til vindkryds på spær";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = 2;
        double price = quantity * material.getUnit_price();

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }

    //Beregn universal højre
    public Bom calculateUniversalRight(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(17, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Til montering af spær på rem";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = calculateRafters(width, length).getQuantity();
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }

    //Beregn universal venstre
    public Bom calculateUniversalLeft(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(18, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Til montering af spær på rem";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = calculateRafters(width, length).getQuantity();
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }

    //Beregn skruer til stern og vandbrædt
    public Bom calculateScrewsForSternAndWaterBoard(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(19, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Til montering af stern og vandbrædt";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = 1;
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }

    //Beregn beslagskruer
    public Bom calculateHingeScrews(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(20, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Til montering af universalbeslag og hulbånd";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = 3;
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }

    //Beregn bræddebolt
    public Bom calculateBoardBolt(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(21, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Til montering af rem på stolper";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = calculatePosts(width, length).getQuantity()*2;
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }

    //Beregn firkantskiver
    public Bom calculateSquareWashers(int width, int length) throws DatabaseException {
        Material material = MaterialFacade.getMaterialById(22, connectionPool);
        int materialId = material.getMaterialId();
        String definition = "Til montering af rem på stolper";
        String description = material.getDescription();
        String unit = material.getUnit();
        int quantity = calculatePosts(width, length).getQuantity() * 2;
        double price = 0;
        for (int i = 0; i < quantity; i++) {
            price += material.getUnit_price();
        }

        Bom bom = new Bom(materialId, definition, description, unit, price, quantity);
        return bom;
    }
}
