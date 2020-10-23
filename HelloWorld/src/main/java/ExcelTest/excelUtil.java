//package ExcelTest;
//
//import org.apache.poi.hssf.usermodel.HSSFDateUtil;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//
//public class excelUtil {
//    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
//        Workbook workbook = null;
//            workbook = new HSSFWorkbook(inputStream);
//        return workbook;
//    }
//
//    public static ArrayList<seatBody> excelTo(String URL) throws IOException {
//        //创建list集合存放对象
//        ArrayList<seatBody> list = new ArrayList<seatBody>();
//
//        File file = new File(URL);
//        // 获取Excel文件
//        if (!file.exists()) {
//            System.out.println("指定的Excel文件不存在！");
//            return null;
//        }
//
//        // 获取Excel工作簿
//        FileInputStream inputStream = new FileInputStream(file);
//        Workbook workbook = getWorkbook(inputStream, "xlsx");
////        workbook = new XSSFWorkbook(new FileInputStream(file));
//        //代码解释：读取默认第一个工作表sheet
//        Sheet sheet = workbook.getSheetAt(0);
//        //代码解释：获取sheet中最后一行行号
//        int lastRowNum = sheet.getLastRowNum();
//        // System.out.println("lastRowNum========="+lastRowNum);
//        //代码解释：循环所有行
//        ArrayList<String> list2 = new ArrayList<String>();
//        for (int i = 1; i <= lastRowNum; i++) {
//            //代码解释：获取当前行中的内容
//            Row row = sheet.getRow(i);
//            short cell = row.getLastCellNum();
//            //  System.out.println("cellnumber======="+cell);
//            if (row != null && cell != 0) {
//                for (int j = 0; j < cell; j++) {
//                    seatBody seatBody = new seatBody();
//                    Cell name = row.getCell(j);
//                    seatBody.setWorkUID(getValue(name));
//                    seatBody.setWorkerName(getValue(name));
//                    seatBody.setWorkerNickName(getValue(name));
//                    list.add(seatBody);
//                }
//            }
//        }
//        return list;
//    }
//
//    //取单元格中的值
//    public static String getValue(Cell cell) {
//        String result = "";
//        if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
//            //返回布尔类型的值
//            result = cell.getBooleanCellValue() + "";
//        } else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
//            //返回数值类型的值
//            if (HSSFDateUtil.isCellDateFormatted(cell)) {
//                result = DateUtil.getJavaDate(cell.getNumericCellValue()).toString();
//            } else {
//                result = cell.getNumericCellValue() + "";
//            }
//            return String.valueOf(cell.getNumericCellValue());
//        } else if (cell.getCellType() == cell.CELL_TYPE_FORMULA) {
//            result = cell.getCellFormula();
//        } else if (cell.getCellType() == cell.CELL_TYPE_STRING) {
//            result = cell.getStringCellValue();
//        } else {
//            //返回字符口串类型的值
//            result = cell.getStringCellValue();
//        }
//        return result;
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.out.println(excelTo("C:\\Users\\zhangjinqiu03\\Desktop\\11.xlsx"));
//    }
//}
