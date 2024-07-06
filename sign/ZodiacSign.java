// package to create and store files in
package sign;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// path to sign instance of service
@Path("/sign")
public class ZodiacSign{
  // array of the start and end dates for each sign
  private static String[][] signs = {{"Aries", "21/03", "19/04"},
                                     {"Taurus", "20/04", "20/05"},
                                     {"Gemini", "21/05", "20/06"},
                                     {"Cancer", "21/06", "22/07"},
                                     {"Leo", "23/07", "22/08"},
                                     {"Virgo", "23/08", "22/09"},
                                     {"Libra", "23/09", "22/10"},
                                     {"Scorpio", "23/10", "21/11"},
                                     {"Sagittarius", "22/11", "21/12"},
                                     {"Aquarius", "20/01", "18/02"},
                                     {"Pisces", "19/02", "20/03"}};

  // method that returns the sign of the specified day and month in plain text
  @GET
  @Path("/{day}/{month}")
  @Produces(MediaType.TEXT_PLAIN)
  public String sign(@PathParam("day") int day, @PathParam("month") int month) throws ParseException{
    // determine if the corresponding sign of the date is capricorn
    if((month == 12 && day > 21) || (month == 1 && day < 20)){
      return "Capricorn";
    }

    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(day + "/" + month + "/2020");

    // find which date range the specified day and month falls in and return the corresponding sign if the sign is not capricorn
    for(int i = 0; i < 11; i++){
      Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(signs[i][1] + "/2020");
      Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(signs[i][2] + "/2020");

      if(date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0){
        return signs[i][0];
      }
    }

    return null;
  }
}
