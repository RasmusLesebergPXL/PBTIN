package be.pxl.rct.rollercoaster;

public class RollerCoasterMapper {

    public static RollerCoasterType mapDataToRollerCoasterType(String[] list) {
        RollerCoasterType rollerCoasterType = new RollerCoasterType();

        try {
            if (list.length != 10) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            rollerCoasterType.setId(Integer.parseInt(list[0]));
            rollerCoasterType.setType(list[1]);
            rollerCoasterType.setGenre(RideGenre.valueOf(list[2].replace(" ", "_").toUpperCase()));
            rollerCoasterType.setExcitement(Double.parseDouble(list[3]));
            rollerCoasterType.setExcitementRating((list[4]));
            rollerCoasterType.setNausea(Double.parseDouble(list[5]));
            rollerCoasterType.setNauseaRating(list[6]);
            rollerCoasterType.setCost(Double.parseDouble(list[7]));
            rollerCoasterType.setPassengers(Integer.parseInt(list[8]));
            rollerCoasterType.setRunningTime(Integer.parseInt(list[9]));

            return rollerCoasterType;
        }
        catch (IndexOutOfBoundsException e) {
            e.getStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }
}
