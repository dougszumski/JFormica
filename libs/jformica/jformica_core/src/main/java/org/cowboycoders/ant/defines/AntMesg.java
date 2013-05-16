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

/*
 * Copyright 2010 Dynastream Innovations Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cowboycoders.ant.defines;

import org.cowboycoders.ant.defines.AntDefine;

/**
 * AntMesg contains definitions for ANT message IDs
 * 
 * Android ANT packets are in the format:
 * 
 * II JJ ------
 * 
 * where:   II     is the 1 byte size of the ANT message (0-249)  
 *          JJ     is the 1 byte ID of the ANT message (1-255, 0 is invalid)
 *          ------ is the data of the ANT message (0-249 bytes of data)
 *
 * Note, no sync byte or checksum byte is included. 
 *
 * Multiple packets can be concatenated for a transmit request.  The maximum number is hardware dependent.
 */
public class AntMesg {
    
    /** We do not include a sync byte at application level. */
    public static final byte MESG_SYNC_SIZE                       =((byte)0);
    public static final byte MESG_SIZE_SIZE                       =((byte)1);
    public static final byte MESG_ID_SIZE                         =((byte)1);
    public static final byte MESG_CHANNEL_NUM_SIZE                =((byte)1);
    /** NOTE: This could increase in the future. */
    public static final byte MESG_EXT_MESG_BF_SIZE                =((byte)1);
    /** We do not include a checksum at application level. */
    public static final byte MESG_CHECKSUM_SIZE                   =((byte)0);
    public static final byte MESG_DATA_SIZE                       =((byte)9);

    /** The largest serial message is an ANT data message with all of the extended fields */
    public static final byte MESG_ANT_MAX_PAYLOAD_SIZE            =AntDefine.ANT_STANDARD_DATA_PAYLOAD_SIZE;
        
    /** ANT device ID (4 bytes) +  Padding for ANT EXT string size(19 bytes) */
    public static final byte MESG_MAX_EXT_DATA_SIZE               =(AntDefine.ANT_EXT_MESG_DEVICE_ID_FIELD_SIZE + AntDefine.ANT_EXT_STRING_SIZE);    

    /** ANT data payload (8 bytes) + extended bitfield (1 byte) + extended data (10 bytes) */
    public static final byte MESG_MAX_DATA_SIZE                   =(MESG_ANT_MAX_PAYLOAD_SIZE + MESG_EXT_MESG_BF_SIZE + MESG_MAX_EXT_DATA_SIZE);
    /** this is the maximum value that the serial message size value is allowed to be */
    public static final byte MESG_MAX_SIZE_VALUE                  =(MESG_MAX_DATA_SIZE + MESG_CHANNEL_NUM_SIZE);
    public static final byte MESG_BUFFER_SIZE                     =(MESG_SIZE_SIZE + MESG_ID_SIZE + MESG_CHANNEL_NUM_SIZE + MESG_MAX_DATA_SIZE + MESG_CHECKSUM_SIZE);
    public static final byte MESG_FRAMED_SIZE                     =(MESG_ID_SIZE + MESG_CHANNEL_NUM_SIZE + MESG_MAX_DATA_SIZE);
    public static final byte MESG_HEADER_SIZE                     =(MESG_SYNC_SIZE + MESG_SIZE_SIZE + MESG_ID_SIZE);
    public static final byte MESG_FRAME_SIZE                      =(MESG_HEADER_SIZE + MESG_CHECKSUM_SIZE);
    public static final byte MESG_MAX_SIZE                        =(MESG_MAX_DATA_SIZE + MESG_FRAME_SIZE);

    public static final byte MESG_SIZE_OFFSET                     =(MESG_SYNC_SIZE);
    public static final byte MESG_ID_OFFSET                       =(MESG_SYNC_SIZE + MESG_SIZE_SIZE);
    public static final byte MESG_DATA_OFFSET                     =(MESG_HEADER_SIZE);
    /** This is the recommended size for serial message buffers if there are no RAM restrictions on the system */
    public static final byte MESG_RECOMMENDED_BUFFER_SIZE         =((byte) 64);

    //////////////////////////////////////////////
    // Message ID's
    //////////////////////////////////////////////
    public static final byte MESG_INVALID_ID                      =((byte)0x00);
    public static final byte MESG_EVENT_ID                        =((byte)0x01);

    public static final byte MESG_VERSION_ID                      =((byte)0x3E);
    public static final byte MESG_RESPONSE_EVENT_ID               =((byte)0x40);

    public static final byte MESG_UNASSIGN_CHANNEL_ID             =((byte)0x41);
    public static final byte MESG_ASSIGN_CHANNEL_ID               =((byte)0x42);
    public static final byte MESG_CHANNEL_MESG_PERIOD_ID          =((byte)0x43);
    public static final byte MESG_CHANNEL_SEARCH_TIMEOUT_ID       =((byte)0x44);
    public static final byte MESG_CHANNEL_RADIO_FREQ_ID           =((byte)0x45);
    public static final byte MESG_NETWORK_KEY_ID                  =((byte)0x46);
    public static final byte MESG_RADIO_TX_POWER_ID               =((byte)0x47);
    public static final byte MESG_RADIO_CW_MODE_ID                =((byte)0x48);
    
    public static final byte MESG_SYSTEM_RESET_ID                 =((byte)0x4A);
    public static final byte MESG_OPEN_CHANNEL_ID                 =((byte)0x4B);
    public static final byte MESG_CLOSE_CHANNEL_ID                =((byte)0x4C);
    public static final byte MESG_REQUEST_ID                      =((byte)0x4D);

    public static final byte MESG_BROADCAST_DATA_ID               =((byte)0x4E);
    public static final byte MESG_ACKNOWLEDGED_DATA_ID            =((byte)0x4F);
    public static final byte MESG_BURST_DATA_ID                   =((byte)0x50);

    public static final byte MESG_CHANNEL_ID_ID                   =((byte)0x51);
    public static final byte MESG_CHANNEL_STATUS_ID               =((byte)0x52);
    public static final byte MESG_RADIO_CW_INIT_ID                =((byte)0x53);
    public static final byte MESG_CAPABILITIES_ID                 =((byte)0x54);

    public static final byte MESG_STACKLIMIT_ID                   =((byte)0x55);

    public static final byte MESG_SCRIPT_DATA_ID                  =((byte)0x56);
    public static final byte MESG_SCRIPT_CMD_ID                   =((byte)0x57);

    public static final byte MESG_ID_LIST_ADD_ID                  =((byte)0x59);
    public static final byte MESG_ID_LIST_CONFIG_ID               =((byte)0x5A);
    public static final byte MESG_OPEN_RX_SCAN_ID                 =((byte)0x5B);

    /**
     *  OBSOLETE: (for 905 radio)
     *  @deprecated
     */
    public static final byte MESG_EXT_CHANNEL_RADIO_FREQ_ID       =((byte)0x5C);
    public static final byte MESG_EXT_BROADCAST_DATA_ID           =((byte)0x5D);
    public static final byte MESG_EXT_ACKNOWLEDGED_DATA_ID        =((byte)0x5E);
    public static final byte MESG_EXT_BURST_DATA_ID               =((byte)0x5F);

    public static final byte MESG_CHANNEL_RADIO_TX_POWER_ID       =((byte)0x60);
    public static final byte MESG_GET_SERIAL_NUM_ID               =((byte)0x61);
    public static final byte MESG_GET_TEMP_CAL_ID                 =((byte)0x62);
    public static final byte MESG_SET_LP_SEARCH_TIMEOUT_ID        =((byte)0x63);
    public static final byte MESG_SET_TX_SEARCH_ON_NEXT_ID        =((byte)0x64);
    public static final byte MESG_SERIAL_NUM_SET_CHANNEL_ID_ID    =((byte)0x65);
    public static final byte MESG_RX_EXT_MESGS_ENABLE_ID          =((byte)0x66); 
    public static final byte MESG_RADIO_CONFIG_ALWAYS_ID          =((byte)0x67);
    public static final byte MESG_ENABLE_LED_FLASH_ID             =((byte)0x68);
    
    public static final byte MESG_XTAL_ENABLE_ID                  =((byte)0x6D);
    
    public static final byte MESG_STARTUP_MESG_ID                 =((byte)0x6F);
    public static final byte MESG_AUTO_FREQ_CONFIG_ID             =((byte)0x70);
    public static final byte MESG_PROX_SEARCH_CONFIG_ID           =((byte)0x71);
    public static final byte MESG_EVENT_BUFFERING_CONFIG_ID       =((byte)0x74);

    
    public static final byte MESG_CUBE_CMD_ID                     =((byte)0x80);

    public static final byte MESG_GET_PIN_DIODE_CONTROL_ID        =((byte)0x8D);
    public static final byte MESG_PIN_DIODE_CONTROL_ID            =((byte)0x8E);
    public static final byte MESG_FIT1_SET_AGC_ID                 =((byte)0x8F);

    /** *** CONFLICT: w/ Sensrcore, Fit1 will never have sensrcore enabled */
    public static final byte MESG_FIT1_SET_EQUIP_STATE_ID         =((byte)0x91);

    // Sensrcore Messages
    public static final byte MESG_SET_CHANNEL_INPUT_MASK_ID       =((byte)0x90);
    public static final byte MESG_SET_CHANNEL_DATA_TYPE_ID        =((byte)0x91);
    public static final byte MESG_READ_PINS_FOR_SECT_ID           =((byte)0x92);
    public static final byte MESG_TIMER_SELECT_ID                 =((byte)0x93);
    public static final byte MESG_ATOD_SETTINGS_ID                =((byte)0x94);
    public static final byte MESG_SET_SHARED_ADDRESS_ID           =((byte)0x95);
    public static final byte MESG_ATOD_EXTERNAL_ENABLE_ID         =((byte)0x96);
    public static final byte MESG_ATOD_PIN_SETUP_ID               =((byte)0x97);
    public static final byte MESG_SETUP_ALARM_ID                  =((byte)0x98);
    public static final byte MESG_ALARM_VARIABLE_MODIFY_TEST_ID   =((byte)0x99);
    public static final byte MESG_PARTIAL_RESET_ID                =((byte)0x9A);
    public static final byte MESG_OVERWRITE_TEMP_CAL_ID           =((byte)0x9B);
    public static final byte MESG_SERIAL_PASSTHRU_SETTINGS_ID     =((byte)0x9C);

    public static final byte MESG_BIST_ID                         =((byte)0xAA);

    public static final byte MESG_UNLOCK_INTERFACE_ID             =((byte)0xAD);
    public static final byte MESG_SERIAL_ERROR_ID                 =((byte)0xAE);
    public static final byte MESG_SET_ID_STRING_ID                =((byte)0xAF);

    public static final byte MESG_PORT_GET_IO_STATE_ID            =((byte)0xB4);
    public static final byte MESG_PORT_SET_IO_STATE_ID            =((byte)0xB5);

    public static final byte MESG_SLEEP_ID                        =((byte)0xC5);
    public static final byte MESG_GET_GRMN_ESN_ID                 =((byte)0xC6);
    public static final byte MESG_SET_USB_INFO_ID                 =((byte)0xC7);

    public static final byte MESG_COMMAND_COMPLETE_RESPONSE_ID    =((byte)0xC8);

    //////////////////////////////////////////////
    // Command complete results
    //////////////////////////////////////////////
    public static final byte MESG_COMMAND_COMPLETE_SUCCESS        =((byte)0x00);
    public static final byte MESG_COMMAND_COMPLETE_RETRY          =((byte)0x1F);

    //////////////////////////////////////////////
    // Message Sizes
    //////////////////////////////////////////////
    public static final byte MESG_INVALID_SIZE                    =((byte)0);

    public static final byte MESG_VERSION_SIZE                    =((byte)13);
    public static final byte MESG_RESPONSE_EVENT_SIZE             =((byte)3);
    public static final byte MESG_CHANNEL_STATUS_SIZE             =((byte)2);

    public static final byte MESG_UNASSIGN_CHANNEL_SIZE           =((byte)1);
    public static final byte MESG_ASSIGN_CHANNEL_SIZE             =((byte)3);
    public static final byte MESG_CHANNEL_ID_SIZE                 =((byte)5);
    public static final byte MESG_CHANNEL_MESG_PERIOD_SIZE        =((byte)3);
    public static final byte MESG_CHANNEL_SEARCH_TIMEOUT_SIZE     =((byte)2);
    public static final byte MESG_CHANNEL_RADIO_FREQ_SIZE         =((byte)2);
    public static final byte MESG_CHANNEL_RADIO_TX_POWER_SIZE     =((byte)2);
    public static final byte MESG_NETWORK_KEY_SIZE                =((byte)9);
    public static final byte MESG_RADIO_TX_POWER_SIZE             =((byte)2);
    public static final byte MESG_RADIO_CW_MODE_SIZE              =((byte)3);
    public static final byte MESG_RADIO_CW_INIT_SIZE              =((byte)1);
    
    public static final byte MESG_SYSTEM_RESET_SIZE               =((byte)1);
    public static final byte MESG_OPEN_CHANNEL_SIZE               =((byte)1);
    public static final byte MESG_CLOSE_CHANNEL_SIZE              =((byte)1);
    public static final byte MESG_REQUEST_SIZE                    =((byte)2);

    public static final byte MESG_CAPABILITIES_SIZE               =((byte)6);
    public static final byte MESG_STACKLIMIT_SIZE                 =((byte)2);

    public static final byte MESG_SCRIPT_DATA_SIZE                =((byte)10);
    public static final byte MESG_SCRIPT_CMD_SIZE                 =((byte)3);

    public static final byte MESG_ID_LIST_ADD_SIZE                =((byte)6);
    public static final byte MESG_ID_LIST_CONFIG_SIZE             =((byte)3);
    public static final byte MESG_OPEN_RX_SCAN_SIZE               =((byte)1);
    public static final byte MESG_EXT_CHANNEL_RADIO_FREQ_SIZE     =((byte)3);

    public static final byte MESG_RADIO_CONFIG_ALWAYS_SIZE        =((byte)2);
    public static final byte MESG_RX_EXT_MESGS_ENABLE_SIZE        =((byte)2);
    public static final byte MESG_SET_TX_SEARCH_ON_NEXT_SIZE      =((byte)2);
    public static final byte MESG_SET_LP_SEARCH_TIMEOUT_SIZE      =((byte)2);

    public static final byte MESG_SERIAL_NUM_SET_CHANNEL_ID_SIZE  =((byte)3);
    public static final byte MESG_ENABLE_LED_FLASH_SIZE           =((byte)2);
    public static final byte MESG_GET_SERIAL_NUM_SIZE             =((byte)4);
    public static final byte MESG_GET_TEMP_CAL_SIZE               =((byte)4);
    
    public static final byte MESG_XTAL_ENABLE_SIZE                =((byte)1);
    public static final byte MESG_STARTUP_MESG_SIZE               =((byte)1);
    public static final byte MESG_AUTO_FREQ_CONFIG_SIZE           =((byte)4);
    public static final byte MESG_PROX_SEARCH_CONFIG_SIZE         =((byte)2);

    public static final byte MESG_GET_PIN_DIODE_CONTROL_SIZE      =((byte)1);
    public static final byte MESG_PIN_DIODE_CONTROL_ID_SIZE       =((byte)2);
    public static final byte MESG_FIT1_SET_EQUIP_STATE_SIZE       =((byte)2);
    public static final byte MESG_FIT1_SET_AGC_SIZE               =((byte)3);
    
    public static final byte MESG_BIST_SIZE                       =((byte)6);
    public static final byte MESG_UNLOCK_INTERFACE_SIZE           =((byte)1);
    public static final byte MESG_SET_SHARED_ADDRESS_SIZE         =((byte)3);

    public static final byte MESG_GET_GRMN_ESN_SIZE               =((byte)5);    

    public static final byte MESG_PORT_SET_IO_STATE_SIZE          =((byte)5);

    public static final byte MESG_EVENT_BUFFERING_CONFIG_SIZE     =((byte)6);

    public static final byte MESG_SLEEP_SIZE                      =((byte)1);


    public static final byte MESG_EXT_DATA_SIZE                   =((byte)13);

    protected AntMesg()
    { 
        // Prevent instantiation
    }
}
