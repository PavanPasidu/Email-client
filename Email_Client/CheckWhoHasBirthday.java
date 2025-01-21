class CheckWhoHasBirthday { 
    private boolean correctDateInput  =  true; 
    boolean todayIsBirthday(String date,String todayORgivenDate){ 
      String[] dateList=date.split("/"); 
      String[] todaydateList=todayORgivenDate.split("/"); 
       
      //check that all the parts of date is given as input 
      if(dateList.length<3 && todaydateList.length<3) { 
        correctDateInput  = false; 
        return false; 
      } 
       
      //check whether given input is in correct format 
      //else return false 
      if(dateList[0].length()!=4 | dateList[1].length()!=2 | dateList[2].length()!=2  |
          todaydateList[0].length()!=4 | todaydateList[1].length()!=2 | todaydateList[2].length()!=2) 
      { 
        correctDateInput  = false; 
        return false; 
      } 
      else 
      { 
        try { 
          //check who has the birthday 
          if(dateList[1].equals(todaydateList[1]) && dateList[2].equals(todaydateList[2])) { 
          return true; 
          } 
        }catch(ArrayIndexOutOfBoundsException ioe){ 
          ioe.printStackTrace(); 
        } 
      } 
      return false; 
       
    } 
    //return true if date is correct 
    //else return false 
    boolean getCorrectDate() { 
      // TODO Auto-generated method stub 
      return correctDateInput; 
    } 
  } 
   