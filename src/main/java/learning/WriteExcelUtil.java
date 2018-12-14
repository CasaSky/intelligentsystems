package learning;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteExcelUtil {

    public static void write(List<Point> dataSet) {
        //Blank workbook
        HSSFWorkbook workbook = new HSSFWorkbook();

        //Create a blank sheet
        HSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("0", new Object[]{"ID", "AGE", "SALARY"});
        for (int i=0; i<20; i++) {
            Point point = dataSet.get(i);
            data.put(i+1+"", new Object[]{i, point.getX()+"", point.getY()+""});
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
            FileOutputStream out = new FileOutputStream(new File("personData.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("personData.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
