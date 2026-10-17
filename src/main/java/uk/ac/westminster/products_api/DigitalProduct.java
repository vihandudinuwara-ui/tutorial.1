
package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {

    private String downloadLink;
    private double fileSize;

    public DigitalProduct(Long id, String name, double price,
                          String downloadLink, double fileSize) {
        super(id, name, price);
        this.downloadLink = downloadLink;
        this.fileSize = fileSize;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }
}
