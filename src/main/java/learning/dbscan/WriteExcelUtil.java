package learning.dbscan;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteExcelUtil {

    public static void write(List<Point> dataSet) {
        //Blank workbook
        Workbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        Sheet sheet = workbook.createSheet("Person Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("0", new Object[]{"ID", "AGE", "SALARY"});
        for (int i=0; i<dataSet.size(); i++) {
            Point point = dataSet.get(i);
            List<Double> coordinates = point.getCoordinates();
            Object[] values = new Object[5];
            values[0] = i;
            int x = 1;
            for (Double coordinate : coordinates) {
                values[x] = coordinate.toString().replace(".", ",")+"";
                x++;
            }
            data.put(i+1+"", values);
        }

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("dataset.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("dataset.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
