package descriptorsPMT;

import java.io.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class IOD_descriptor extends Descriptor {
	public IOD_descriptor(){
		setDescriptor_tag(29);
	}
	public IOD_descriptor(int descriptor_tag, int descriptor_length){
		setDescriptor_tag(descriptor_tag);
		setDescriptor_length(descriptor_length);
	}

	public IOD_descriptor read(FileInputStream fi){
		setScope_of_IOD_label(br.lerBytes(fi, 1));
		setIOD_label(br.lerBytes(fi, 1));
		setInitialObjectDescriptor(br.lerBytes(fi, 1));
		return this;
	}
	private int scope_of_IOD_label;
	public int getScope_of_IOD_label(){
		return scope_of_IOD_label;
	}
	public void setScope_of_IOD_label(int scope_of_IOD_label){
		this.scope_of_IOD_label = scope_of_IOD_label;
	}
	private int IOD_label;
	public int getIOD_label(){
		return IOD_label;
	}
	public void setIOD_label(int IOD_label){
		this.IOD_label = IOD_label;
	}
	private int InitialObjectDescriptor;
	public int getInitialObjectDescriptor(){
		return InitialObjectDescriptor;
	}
	public void setInitialObjectDescriptor(int InitialObjectDescriptor){
		this.InitialObjectDescriptor = InitialObjectDescriptor;
	}
	public String toString(){
		String s = super.toString();
		s += "Scope_of_IOD_label: "+br.binaryString(scope_of_IOD_label,24)+"\n";
		s += "IOD_label: "+br.binaryString(IOD_label,24)+"\n";
		s += "InitialObjectDescriptor: "+br.binaryString(InitialObjectDescriptor,24)+"\n";
		return s;
	}
	public boolean equals(Object obj) {
	    if (obj instanceof IOD_descriptor) {
	    	if(!super.equals(obj)){
		    		return false;
		    }
	        IOD_descriptor other = (IOD_descriptor) obj;
	        EqualsBuilder builder = new EqualsBuilder();
	        builder.append(getScope_of_IOD_label(), other.getScope_of_IOD_label());
	        builder.append(getIOD_label(), other.getIOD_label());
	        builder.append(getInitialObjectDescriptor(), other.getInitialObjectDescriptor());
    		return builder.isEquals();
        }
        return false;
    }
}
