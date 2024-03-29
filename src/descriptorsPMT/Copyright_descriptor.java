package descriptorsPMT;

import java.io.*;
import java.util.ArrayList;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Copyright_descriptor extends Descriptor {

	public Copyright_descriptor(){
		setDescriptor_tag(13);
	}
	public Copyright_descriptor(int descriptor_tag, int descriptor_length){
		setDescriptor_tag(descriptor_tag);
		setDescriptor_length(descriptor_length);
	}
	public Copyright_descriptor read(FileInputStream fi){
		setCopyright_identifier(br.lerBytes(fi, 4));
		for(int i = 0; i < (descriptor_length - 4); i++){
			setAdditional_copyright_info(br.lerBytes(fi, 1));
		}
		return this;
	}
	private int copyright_identifier;
	public int getCopyright_identifier(){
		return copyright_identifier;
	}
	public void setCopyright_identifier(int copyright_identifier){
		this.copyright_identifier = copyright_identifier;
	}
	private ArrayList<Integer> additional_copyright_info = new ArrayList<Integer>();
	public ArrayList<Integer> getAdditional_copyright_info(){
		return additional_copyright_info;
	}
	public void setAdditional_copyright_info(Integer additional_copyright_info){
		this.additional_copyright_info.add(additional_copyright_info);
	}
	public String toString(){
		String s = super.toString();
		s += "Copyright_identifier: "+br.binaryString(copyright_identifier)+"\n";
		for(Integer i : additional_copyright_info){
			s += "Additional_copyright_info: "+br.binaryString(i,24)+"\n";
		}
		return s;
	}
	public boolean equals(Object obj) {
	    if (obj instanceof Copyright_descriptor) {
	    	if(!super.equals(obj)){
		    		return false;
		    }
	        Copyright_descriptor other = (Copyright_descriptor) obj;
	        EqualsBuilder builder = new EqualsBuilder();
	        builder.append(getCopyright_identifier(), other.getCopyright_identifier());
	        builder.append(getAdditional_copyright_info(), other.getAdditional_copyright_info());
    		return builder.isEquals();
        }
        return false;
    }
}
