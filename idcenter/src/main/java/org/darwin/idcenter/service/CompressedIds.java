/**
 * org.darwin.idcenter.CompressedIds.java
 * created by Tianxin(tianjige@163.com) on 2015年8月6日 下午12:56:58
 */
package org.darwin.idcenter.service;

import java.io.Serializable;

/**
 * 一个ID列表的压缩类
 * <br/>created by Tianxin on 2015年8月6日 下午12:56:58
 */
public interface CompressedIds<N extends Number> extends Serializable{
  
  /**
   * 获取全部的值
   * @return
   * <br/>created by Tianxin on 2015年8月6日 下午1:05:34
   */
  N[] getValues();
}
