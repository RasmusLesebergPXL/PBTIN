package be.pxl.rct.commands;

import be.pxl.rct.exceptions.CommandNotFoundException;
import be.pxl.rct.rollercoaster.RideGenre;
import be.pxl.rct.rollercoaster.RollerCoasterType;
import be.pxl.rct.shop.ShopType;
import org.apache.commons.lang3.EnumUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShowTypeCommand {

    private static List<String> filters;
    public static double MIN_FILTER_AMOUNT;
    public static double MAX_FILTER_AMOUNT = 100000;
    public static RideGenre GENRE;

    public static void execute(String[] commands, ArrayList<RollerCoasterType> rides){
        try {
            //INPUT EXCEPTIONS
            if (commands.length == 1 || !commands[1].equalsIgnoreCase("-type") ) {
                throw new CommandNotFoundException("Add -type parameter to show type");
            }
            else if (commands.length == 2) {
                throw new CommandNotFoundException("Enter a show -type. (rollercoaster, shop, or ?)");
            }
            else if(commands[2].trim().equals("?")) {
                System.out.println(
                        """
                                List of possible inputs for show-type:
                                ======================================
                                show -type shop
                                show -type rollercoaster (-all)
                                show -type rollercoaster <filter> <parameter>
                                show -type rollercoaster <filter> <parameter> ... -sorted <parameter>
                                
                                <filters>               <sorting>
                                -min-cost <int>         -sorted cost
                                -max-cost <int>         -sorted type
                                -ride <String>          -sorted
                                """);
                return;
            }

            filters = Arrays.asList(commands);
            String showCommand = String.join(" ", commands).toLowerCase().trim();

            //SHOW -TYPE SHOP
            if(commands[2].equalsIgnoreCase("shop")){
                for (ShopType type : ShopType.values()){
                    System.out.printf("%s [%s]\r\n",type.name(),type.getItemType());
                }
            }

            //SHOW -TYPE ROLLERCOASTER (WITH -ALL)
            else if((showCommand.equals("show -type rollercoaster") || showCommand.equals("show -type rollercoaster -all"))) {
                generateOutput(rides);
            }

            //SETTING THE FILTERS
            else if(commands.length >= 5) {
                String[] filterInput = Arrays.copyOfRange(commands, 3, commands.length);
                filters = Arrays.asList(filterInput);

                if(filters.contains("-min-cost")) {
                    if(amountIndexIsNotOutOfBounds(filters, "-min-cost")) {
                        double minAmount = Double.parseDouble(filters.get(filters.indexOf("-min-cost") + 1));
                        if(minAmount >= 0) {
                            MIN_FILTER_AMOUNT = minAmount;
                        }
                        else { throw new CommandNotFoundException("Min cost amount cannot be less than 0"); }
                    }
                    else { return; }
                }
                if(filters.contains("-max-cost")) {
                    if(amountIndexIsNotOutOfBounds(filters, "-max-cost")) {
                        double maxAmount = Double.parseDouble(filters.get(filters.indexOf("-max-cost") + 1));
                        if(maxAmount > MIN_FILTER_AMOUNT) {
                            MAX_FILTER_AMOUNT = maxAmount;
                        }
                        else { throw new CommandNotFoundException("Max amount can't be higher than min amount"); }
                    }
                    else { return; }
                }
                if(filters.contains("-ride")) {
                    if(amountIndexIsNotOutOfBounds(filters, "-ride")) {
                        String genreEnum = filters.get(filters.indexOf("-ride") + 1).toUpperCase();
                        if (EnumUtils.isValidEnum(RideGenre.class, genreEnum)) {
                            GENRE = RideGenre.valueOf(genreEnum);
                        }
                        else { throw new CommandNotFoundException("The given genre for -ride is not a RideGenre"); }
                    }
                    else { return; }
                }

                generateOutput(rides
                        .stream()
                        .filter(v -> v.getCost() > MIN_FILTER_AMOUNT)
                        .filter(x -> x.getCost() < MAX_FILTER_AMOUNT)
                        .filter(w -> GENRE != null ? w.getGenre().equals(GENRE) : w.getGenre().equals(w.getGenre()))
                        .sorted((h1, h2) -> {
                            if(filters.contains("type")) {
                                return h1.getType().compareTo(h2.getType());
                            }
                            else if(filters.contains("cost")) {
                                return Double.compare(h1.getCost(), h2.getCost());
                            }
                            else {
                                return Integer.compare(h1.getId(), h2.getId());
                            }
                        })
                        .collect(Collectors.toList()));
            }
            else { throw new CommandNotFoundException("The input does not match 'show -type rollercoaster <filter> " +
                                                      "<parameter>'.\nUse 'show -type ?' to list possible inputs"); }
        } catch (CommandNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Cannot parse the given parameter");
        }
    }

    private static boolean amountIndexIsNotOutOfBounds(List<String> list, String filter) {
        try {
            int index = list.indexOf(filter) + 1;
            if (index > list.size() - 1) {
                throw new CommandNotFoundException("One or more of the given filters do not have format <filter> <parameter>");
            }
            return true;
        }
        catch (CommandNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void generateOutput(List<RollerCoasterType> filteredRides) {
        System.out.println(
                """
                        ID     Type                          Genre               Cost                 Nausea         Excitement
                        =======================================================================================================""");
        for (RollerCoasterType rollerCoaster : filteredRides){
            if (filters.contains("-all")) {
                System.out.printf("%-7d%-30s%-20s€%-20.2f%-15.2f%-7.2f\n",
                        rollerCoaster.getId(), rollerCoaster.getType() , rollerCoaster.getGenre(), rollerCoaster.getCost(),
                        rollerCoaster.getNausea(), rollerCoaster.getExcitement());
            } else {
                System.out.printf("%-7d%-30s%-20s€%-20.2f\n",
                        rollerCoaster.getId(), rollerCoaster.getType() , rollerCoaster.getGenre(), rollerCoaster.getCost());
            }
        }
    }
}
