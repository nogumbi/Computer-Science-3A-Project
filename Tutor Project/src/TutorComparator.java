import java.util.Comparator;

public class TutorComparator implements Comparator<Tutor>
{
    @Override
    public int compare(Tutor x, Tutor y)
    {
        if (x.getStatus().equalsIgnoreCase("Free") && y.getStatus().equalsIgnoreCase("Occupied"))
        {
            return -1;
        }
        if (x.getStatus().equalsIgnoreCase("Occupied") && y.getStatus().equalsIgnoreCase("Free"))
        {
            return 1;
        }
        if (x.getDistance() < y.getDistance())
        {
            return -1;
        }
        if (x.getDistance() > y.getDistance())
        {
            return 1;
        }
        if (x.getRating() > y.getRating())
        {
            return -1;
        }
        if (x.getRating() < y.getRating())
        {
            return 1;
        }
   

        return 0;
    }
}