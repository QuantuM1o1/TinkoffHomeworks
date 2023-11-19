package edu.hw6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber", "MultipleStringLiterals"})
public class Task6 {
    private final static Logger LOGGER = LogManager.getLogger();

    private static final String FORMATTING = "%1$";
    private static final int LENGTH_OF_PORT = 5;
    private static final int NUMBER_OF_REGISTERED_PORTS = 49152;

    private static final Map<Integer, String> COMMON_PORTS;

    static {
        COMMON_PORTS = new HashMap<>();
        COMMON_PORTS.put(80, "HTTP");
        COMMON_PORTS.put(21, "FTP");
        COMMON_PORTS.put(25, "SMTP");
        COMMON_PORTS.put(22, "SSH");
        COMMON_PORTS.put(443, "HTTPS");
        COMMON_PORTS.put(53, "DNS");
        COMMON_PORTS.put(3306, "MySQL Database");
        COMMON_PORTS.put(5432, "PostgreSQL Database");
        COMMON_PORTS.put(3389, "Remote Desktop Protocol");
        COMMON_PORTS.put(27017, "MongoDB Database");
        COMMON_PORTS.put(1521, "Oracle Database");
        COMMON_PORTS.put(49152, "Windows RPC");
        COMMON_PORTS.put(5353, "mDNS");
        COMMON_PORTS.put(5672, "AMQP");
        COMMON_PORTS.put(5355, "LLMNR");
        COMMON_PORTS.put(49153, "Windows RPC");
        COMMON_PORTS.put(135, "Microsoft EPMAP");
        COMMON_PORTS.put(137, "NetBIOS Name Service");
        COMMON_PORTS.put(138, "NetBIOS Datagram Service");
        COMMON_PORTS.put(139, "NetBIOS Session Service");
        COMMON_PORTS.put(445, "Microsoft-DS");
        COMMON_PORTS.put(843, "Adobe Flash");
        COMMON_PORTS.put(1900, "Simple Service Discovery Protocol");
        COMMON_PORTS.put(23, "Telnet");
        COMMON_PORTS.put(110, "POP3");
        COMMON_PORTS.put(143, "IMAP");
        COMMON_PORTS.put(67, "DHCP");
        COMMON_PORTS.put(68, "DHCP");
        COMMON_PORTS.put(123, "NTP");
        COMMON_PORTS.put(161, "SNMP");
        COMMON_PORTS.put(162, "SNMP");
        COMMON_PORTS.put(8080, "HTTP Proxy");
        COMMON_PORTS.put(1080, "SOCKS");
        COMMON_PORTS.put(636, "LDAP");
        COMMON_PORTS.put(389, "LDAP");
        COMMON_PORTS.put(5722, "SMB2");
        COMMON_PORTS.put(500, "IKE");
        COMMON_PORTS.put(1701, "L2TP");
        COMMON_PORTS.put(1723, "PPTP");
        COMMON_PORTS.put(5060, "SIP");
        COMMON_PORTS.put(5061, "SIP");
        COMMON_PORTS.put(3128, "HTTPS Proxy");
        COMMON_PORTS.put(5900, "VNC");
        COMMON_PORTS.put(6667, "IRC");
        COMMON_PORTS.put(6697, "IRC");
        COMMON_PORTS.put(548, "AFP");
        COMMON_PORTS.put(2049, "NFS");
        COMMON_PORTS.put(6379, "Redis");
        COMMON_PORTS.put(11211, "Memcached");
        COMMON_PORTS.put(873, "Rsync");
        COMMON_PORTS.put(5222, "XMPP");
        COMMON_PORTS.put(5223, "XMPP");
        COMMON_PORTS.put(3702, "Web Services Dynamic Discovery");
        COMMON_PORTS.put(5050, "Yahoo! Messenger");
        COMMON_PORTS.put(5357, "Web Services for Devices");
        COMMON_PORTS.put(7680, "Delivery Optimization for Windows 10");
        COMMON_PORTS.put(17500, "Dropbox LanSync Protocol");
        COMMON_PORTS.put(27015, "Steam");
    }

    private Task6() {
    }

    public static List<Integer> scanPorts() {
        List<Integer> list = new ArrayList<>();
        LOGGER.info("Протокол  Порт   Сервис");
        for (int i = 0; i < NUMBER_OF_REGISTERED_PORTS; i++) {
            try (ServerSocket serverSocket = new ServerSocket(i)) {
                serverSocket.getChannel();
            } catch (IOException e) {
                list.add(i);
                LOGGER.info("TCP       "
                    + String.format(FORMATTING + LENGTH_OF_PORT + "s", i)
                    + "  " + COMMON_PORTS.getOrDefault(i, ""));
            }
            try (DatagramSocket datagramSocket = new DatagramSocket(i)) {
                datagramSocket.getChannel();
            } catch (SocketException e) {
                list.add(i);
                LOGGER.info("UDP       "
                    + String.format(FORMATTING + LENGTH_OF_PORT + "s", i)
                    + "  " + COMMON_PORTS.getOrDefault(i, ""));
            }
        }
        return list;
    }
}
