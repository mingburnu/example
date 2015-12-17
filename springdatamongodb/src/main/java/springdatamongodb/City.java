package springdatamongodb;

import java.io.*;

public class City implements Serializable
{
    private String city;
    private double[] loc;
    private int pop;
    private String state;
    private String id;

    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public double[] getLoc()
    {
        return loc;
    }
    public void setLoc(double[] loc)
    {
        this.loc = loc;
    }
    public int getPop()
    {
        return pop;
    }
    public void setPop(int pop)
    {
        this.pop = pop;
    }
    public String getState()
    {
        return state;
    }
    public void setState(String state)
    {
        this.state = state;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
}