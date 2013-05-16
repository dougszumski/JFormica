/**
 *     Copyright (c) 2012, Will Szumski
 *
 *     This file is part of formicidae.
 *
 *     formicidae is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     formicidae is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with formicidae.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package org.cowboycoders.ant.messages.data;

import org.cowboycoders.ant.messages.Message;
import org.cowboycoders.ant.messages.MessageId;

/**
 * Standard broadcast message
 * @author will
 *
 */
public class BroadcastDataMessage extends DataMessage {
  
  public BroadcastDataMessage() {
    this(0);
  }
  
  public BroadcastDataMessage(
      Integer channelNo) {
    this(new Message(), MessageId.BROADCAST_DATA, channelNo);
  }

  protected BroadcastDataMessage(Message message, MessageId id,
      Integer channelNo) {
    super(message, id ,channelNo);
  }

}
