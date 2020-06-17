import java.util.ArrayList;
import java.util.List;
/*MEDIATOR PATTERN*/
class a
{
    int no;
    a(int n)
    {
        no=n;
    }
    protected void print()
    {
        System.out.println("HI"+no);
    }
}
class b extends a
{
    b(int n)
    {
        super(n);
    }
}
/*ABSTRACT FACTORY METHOD*/
interface ComputerAbstractFactory
{
    Computer createComputer();
}
class PcFactory implements ComputerAbstractFactory
{
    String ram;
    PcFactory(String r)
    {
        ram=r;
    }

    @Override
    public Computer createComputer() {
        return new Pc(ram);
    }
}
abstract class Computer
{
    public abstract String getRam();
}
class Pc extends Computer
{
    String ram;
    Pc(String r)
    {
        ram=r;
    }
    public String getRam()
    {
        return ram;
    }
}
/*COMPOSITE*/ /*AND*/ /*TEMPLATE METHOD*/
interface Shape
{
    void drawi(String color);
}
class Triangle implements Shape
{
    @Override
    public void drawi(String color) {
        System.out.println("Color in Triangle:-"+color);
    }
}
class Circle implements Shape
{
    @Override
    public void drawi(String color) {
        System.out.println("Color in Circle:-"+color);
    }
}
class Draw implements Shape
{
    List<Shape> shapeList=new ArrayList<Shape>();

    @Override
    public void drawi(String color) {
        for (Shape sh: shapeList)
        {
            sh.drawi("Red");
        }
    }
}
class Color
{
    String co()
    {
        return "red";
    }
}
/*SINGLETON METHOD*/
public class pattern
{
    public static final pattern design=new pattern();
    private pattern()
    {}
    public static pattern DesignInstance()
    {
        return design;
    }
    public static void main(String args[])
    {
        Draw d1=new Draw();
        Color col=new Color();
        d1.drawi(col.co());//BRIDGE METHOD
        b abc=new b(5);
        abc.print();
    }
}