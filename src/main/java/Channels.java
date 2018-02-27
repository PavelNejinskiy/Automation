import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Channels {

    static String url = "G:\\SaveFilesDB\\list\\IDODESSA.txt";


    List<String> getChannelsID() throws IOException {
        File file = new File(url);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<String>();
        String s = null;
        while ((s = reader.readLine())!=null)
        {
            list.add(s);
        }
        return list;
    }

    List <String> getChannels() throws IOException
    {
        List<String> listCH = new ArrayList<String>();

        String commonAdress1 = "#chanlist_";
        String commonAdress2 = " > div:nth-child(2) > div:nth-child(1) > p:nth-child(1)";
        String com = "";

        for (int i = 0; i < getChannelsID().size(); i++) {
            listCH.add(commonAdress1 + getChannelsID().get(i) + commonAdress2);
        }
// #chanlist_1022 > div:nth-child(2) > div:nth-child(1) > p:nth-child(1)
        return listCH;
    }

    public static void main(String[] args) throws IOException {

        Channels ch = new Channels();

        System.out.println(ch.getChannelsID().size());
        System.out.println(ch.getChannels().size());

        for (String s : ch.getChannels()) {
            System.out.println(s);
        }
    }


}
