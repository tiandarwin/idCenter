/**
 * org.darwin.idcenter.impl.IDServiceImpl.java
 * created by Tianxin(tianjige@163.com) on 2015年8月6日 下午1:06:49
 */
package org.darwin.idcenter.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 最终对外暴露的ID服务对象
 * <br/>created by Tianxin on 2015年8月6日 下午1:06:49
 */
@Service
public class IDServiceImpl implements IDService{
  
  /**
   * 默认生成的该类的LOG记录器，使用slf4j组件。避免产生编译警告，使用protected修饰符。
   */
  protected final static Logger LOG = LoggerFactory.getLogger(IDServiceImpl.class);

  public long nextValue(String sequence) {
    long[] vals = nextValues(sequence, 1);
    return vals[0];
  }

  public long[] nextValues(String sequence, int count) {
    // TODO Auto-generated method stub
    return null;
  }

  public Map<String, long[]> nextValues(Map<String, Integer> sequenceSizes) {
    Map<String, long[]> map = new HashMap<String, long[]>(sequenceSizes.size() * 2);
    for(Entry<String, Integer> entry : sequenceSizes.entrySet()){
      String seqName = entry.getKey();
      int count = entry.getValue();
      map.put(seqName, nextValues(seqName, count));
    }
    return map;
  }

  public CompressedIds<Long> nextCompressedValues(String sequence, int count) {
    // TODO Auto-generated method stub
    return null;
  }

  public int nextIntValue(String sequence) {
    long nextVal = nextValue(sequence);
    return (int)nextVal;
  }

  public int[] nextIntValues(String sequence, int count) {
    long[] vals = nextValues(sequence, count);
    return trans2IntArray(vals);
  }

  public Map<String, int[]> nextIntValues(Map<String, Integer> sequenceSizes) {
    Map<String, int[]> map = new HashMap<String, int[]>(sequenceSizes.size() * 2);
    for(Entry<String, Integer> entry : sequenceSizes.entrySet()){
      String seqName = entry.getKey();
      int count = entry.getValue();
      map.put(seqName, nextIntValues(seqName, count));
    }
    return map;
  }

  public CompressedIds<Integer> nextCompressedIntValues(String sequence, int count) {
    // TODO Auto-generated method stub
    return null;
  }
  
  /**
   * 将long数组转换为int数组
   * @param vals
   * @return
   * <br/>created by Tianxin on 2015年11月25日 下午3:07:09
   */
  public final static int[] trans2IntArray(long[] vals){
    int[] iVals = new int[vals.length];
    for(int i = 0 ; i < vals.length ; i ++){
      iVals[i] = (int) vals[i];
    }
    return iVals;
  }
  
  public static void main(String[] args) {
    System.out.println(Long.MIN_VALUE);
    System.out.println(Long.MAX_VALUE);
  }
}
