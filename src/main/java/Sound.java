import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
  {  
    int sumChanges = 0;
  	for (int i = 0; i < samples.length; i++){
  		if (samples[i] > limit){
  			samples[i] = limit;
  			sumChanges++;
  		}else if( samples[i] < -limit){
  			samples[i] = -limit;
  			sumChanges++;
  		}
  	}
    return sumChanges;
  }



  /** Removes all silence from the beginning of this sound.
   *  Silence is represented by a value of 0.
   *  Precondition: samples contains at least one nonzero value
   *  Postcondition: the length of samples reflects the removal of starting silence
   */
  public void trimSilenceFromBeginning()
  {
    int startAt = 0;
  	for (int i = 0; i < samples.length; i++){
  		if (samples[i] != 0){
  			startAt = i;
  			break;
  		}
  	}
  	int[] newArr = new int[samples.length - startAt];
  	for (int i = 1; i < newArr.length; i++){
  		newArr[i] = samples[startAt + i];
  	}
  	samples = newArr;
  }
}
