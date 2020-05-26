public class Hello {
    public static void main(String args[]){
//        String photoPath = System.getProperty("user.dir")+"\\src\\main\\resources\\photo\\background.jpg";
//        String targetPhoto = System.getProperty("user.dir")+"\\src\\main\\resources\\photo\\new.jpg";
        String photoPath = System.getProperty("user.dir")+"\\src\\main\\java\\photo\\background.jpg";
        String targetPhoto = System.getProperty("user.dir")+"\\src\\main\\java\\photo\\new.jpg";
        System.out.println("photoPath "+photoPath);
        System.out.println("targetPhoto "+targetPhoto);
        CommonUtil commonUtil=new CommonUtil();
        commonUtil.generateIdCard(photoPath,targetPhoto,"120222194854348521","张三");
        System.out.println("Hello");


    }
}
