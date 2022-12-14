package dat.backend.model.services;

public class CarportSVG
{
    public static SVGDrawing createNewSVG(int x, int y, int height, int width, String viewbox)
    {
        return new SVGDrawing(x, y, height, width, viewbox);
    }

    //Stolper
    public static SVGDrawing addPosts(SVGDrawing carport, int width, int length)
    {
        return carport;
    }

    //Spær
    public static SVGDrawing addRafters(SVGDrawing carport, int width, int length)
    {
        for (int i = 0; i < 800; i +=50 )
        {
            carport.addRect(i, 0, 600.0, 4.5);
        }
        return carport;
    }

    //Remme
    public static SVGDrawing addStraps(SVGDrawing carport, int width, int length)
    {
//        for (int i = 0; i < 800; i +=50 )
//        {
//            carport.addRect(0, i, 4.5, 780);
//        }
        return carport;
    }

    //Hulbånd
    public static SVGDrawing addHulband(SVGDrawing carport, int width, int length)
    {
        return carport;
    }

    //Pile
    public static SVGDrawing addArrows(SVGDrawing carport, int width, int length)
    {
        return carport;
    }
}
