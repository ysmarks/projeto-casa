package br.com.internet.mockito.ocr;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ImageCracker {
	
	public static String crackImage(String filePath) {  
	    File imageFile = new File(filePath);  
	    ITesseract instance = new Tesseract();
	    instance.setDatapath("C:\\Users\\ysantos\\Downloads\\mockito\\tessdata"); // path to tessdata directory
	    try {  
	        String result = instance.doOCR(imageFile);  
	        return result;  
	    } catch (TesseractException e) {  
	        System.err.println(e.getMessage());  
	        return " Erro enquanto ler a imagem";  
	    }  
	}

}
