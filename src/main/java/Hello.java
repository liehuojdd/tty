public class Hello {
    public static void main(String args[]){
        String photoPath = System.getProperty("user.dir")+"\\src\\main\\resources\\photo\\background.jpg";
        String targetPhoto = System.getProperty("user.dir")+"\\src\\main\\resources\\photo\\new.jpg";
        CommonUtil commonUtil=new CommonUtil();
        commonUtil.generateIdCard(photoPath,targetPhoto,"120222194854348521","张三");
        System.out.println("Hello");


    }
}
