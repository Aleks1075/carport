package dat.backend.model.services;

public class CarportSVG
{
    public static SVGDrawing createNewSVG(int x, int y, int height, int width, String viewbox)
    {
        return new SVGDrawing(x, y, height, width, viewbox);
    }

    //Spær
    public static int quantityOfRafters(int length)
    {
        double numberOfRafter = Math.ceil(length / 55.0);
        double endRafter = numberOfRafter + 1;
        int quantity = (int) endRafter;
        return quantity;
    }

    public static SVGDrawing addRafters(SVGDrawing carport, int width, int length)
    {
        int placement = 53;
        for(int i = 0; i < quantityOfRafters(length)-1; i ++)
        {
            carport.addRect(40+i*placement, 45, width, 4.5);
        }
        carport.addRect(length+40, 45, width, 4.5);
        return carport;
    }

    //Remme
    public static SVGDrawing addStraps(SVGDrawing carport, int width, int length)
    {
            carport.addRect(45, 70, 5, length);
            carport.addRect(45, width+15, 5, length);
        return carport;
    }

    //Hulbånd
    public static SVGDrawing addHulband(SVGDrawing carport, int width, int length)
    {
        carport.addLine(80, 70, length+10, width+20);
        carport.addLine(80, width+20, length+10, 70);
        return carport;
    }

    //Pile
    public static SVGDrawing addArrows(SVGDrawing carport, int width, int length)
    {
        carport.addArrows(15,45,15,width+45);
        carport.addArrows(35,70,35,width+20);
        carport.addArrows(45,width+80,length+45,width+80);
        carport.addText(12,(width/2)+45,-90, String.valueOf(width) + " cm");
        carport.addText(32,(width/2)+45,-90, String.valueOf(width-70) + " cm");
        carport.addText(length/2+40,width+70,0,(length + " cm"));
        return carport;
    }

    //Stolper
    public static SVGDrawing addPosts(SVGDrawing carport, int width, int length)
    {
        carport.addRect((int) (length*0.20)+45, 67, 11, 11);
        carport.addRect((int) (length*0.80)+45, 67, 11, 11);
        carport.addRect((int) (length*0.20)+45, width+12, 11, 11);
        carport.addRect((int) (length*0.80)+45, width+12, 11, 11);
        return carport;
    }

    //Oversternbrædder fra siden
    public static SVGDrawing addStrapsFromSide(SVGDrawing carportSide, int width, int length)
    {
        carportSide.addRect(45, 45, 15, length);
        return carportSide;
    }

    //Understernbrædder fra siden
    public static SVGDrawing addStrapsFromSide2(SVGDrawing carportSide, int width, int length)
    {
        carportSide.addRect(45, 60, 15, length);
        return carportSide;
    }

    //Stolper fra siden
    public static SVGDrawing addPostsFromSide(SVGDrawing carportSide, int width, int length)
    {
        carportSide.addRect((int) (length*0.20)+45, 75, 190, 11);
        carportSide.addRect((int) (length*0.80)+45, 75, 190, 11);
        return carportSide;
    }

    //Jord
    public static SVGDrawing addGround(SVGDrawing carportSide, int width, int length)
    {
        carportSide.addLine(45, 265, length+45, 265);
        return carportSide;
    }

    //Pile fra siden
    public static SVGDrawing addArrowsFromSide(SVGDrawing carportSide, int width, int length)
    {
        carportSide.addArrows(15,45,15,265);
        carportSide.addArrows(35,60,35,265);
        carportSide.addArrows(45,275+50,length+45,275+50);
        carportSide.addArrows((int)(length*0.80)+45,275+20,length+45,275+20);
        carportSide.addArrows(45,275+20,(int) (length*0.20)+45,275+20);
        carportSide.addArrows((int) (length*0.20)+45,275+20,(int) (length*0.80)+45,275+20);
        carportSide.addText(12,(220/2)+45,-90, String.valueOf(230) + " cm");
        carportSide.addText(32,(220/2)+45,-90, String.valueOf(210) + " cm");
        carportSide.addText(length/2+45,275+40,0,(length + " cm"));
        carportSide.addText((int) ((length*0.20)/2)+45,275+10,0,((int)(length*0.20) + " cm"));
        carportSide.addText(length/2*2,275+10,0,((int)(length*0.20) + " cm"));
        carportSide.addText(length/2+45,275+10,0,((int)(length*0.60) + " cm"));
        return carportSide;
    }
}
