package descriptorsPMT;

import java.io.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class MPEG4_video_descriptor extends Descriptor{
	public MPEG4_video_descriptor(){
		setDescriptor_tag(27);
	}
	public MPEG4_video_descriptor(int descriptor_tag, int descriptor_length){
		setDescriptor_tag(descriptor_tag);
		setDescriptor_length(descriptor_length);
	}
	public MPEG4_video_descriptor read(FileInputStream fi){
		setMPEG4_visual_profile_and_level(br.lerBytes(fi, 1));
		return this;
	}
	private int MPEG4_visual_profile_and_level;
	public int getMPEG4_visual_profile_and_level(){
		return MPEG4_visual_profile_and_level;
	}
	public void setMPEG4_visual_profile_and_level(int MPEG4_visual_profile_and_level){
		this.MPEG4_visual_profile_and_level = MPEG4_visual_profile_and_level;
	}
	public String toString(){
		String s = super.toString();
		s += "MPEG4_visual_profile_and_level: "+br.binaryString(MPEG4_visual_profile_and_level,24)+"\n";
		return s;
	}
	public boolean equals(Object obj) {
	    if (obj instanceof MPEG4_video_descriptor) {
	    	if(!super.equals(obj)){
		    		return false;
		    }
	        MPEG4_video_descriptor other = (MPEG4_video_descriptor) obj;
	        EqualsBuilder builder = new EqualsBuilder();
	        builder.append(getMPEG4_visual_profile_and_level(), other.getMPEG4_visual_profile_and_level());
    		return builder.isEquals();
        }
        return false;
    }
}
