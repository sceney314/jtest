package patten.proxy.stackproxy;

/**
 * Copyright (C), 2015-2019
 * Date:     2019-05-29 11:24
 * Description:
 */
public class ProxyImage implements Image{
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }

}
