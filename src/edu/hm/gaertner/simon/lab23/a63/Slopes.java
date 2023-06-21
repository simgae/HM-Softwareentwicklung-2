package edu.hm.gaertner.simon.lab23.a63;

/** Eine Funktion, die aus Geradenstuecken besteht.
 * @version 2023-05-31
 * @param xy Abwechselnd x und y von Stuetzstellen.
 */
public record Slopes(int... xy) {
    public Slopes {
        assert xy.length >= 4;
        assert xy.length%2 == 0;
        int last = xy[0];
        for(int index = 2; index < xy.length; index += 2) {
            assert last < xy[index];
            last = xy[index];
        }
        xy = xy.clone();
    }

    public int[] xy() {
        throw new UnsupportedOperationException("no access");
    }

    public int apply(int x) {
        if(x == xy[0])
            return xy[1];
        double y = Double.NaN;
        for(int index = 2; Double.isNaN(y) && index < xy.length; index += 2)
            if(x <= xy[index])
                y = new Scaler(xy[index - 2], xy[index - 1], xy[index], xy[index + 1]).map(x);
        return (int)y;
    }
}
