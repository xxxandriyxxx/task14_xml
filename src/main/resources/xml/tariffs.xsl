<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body style="font-family: Arial; font-size: 12px; background-color: #EEE">
                <div style="color: red">
                    <h2>Tariffs</h2>
                </div>
                <table border="3">
                    <tr style="background-color: yellow">
                        <th rowspan="2">Tariff name</th>
                        <th rowspan="2">Operator name</th>
                        <th rowspan="2">Payroll</th>
                        <th colspan="3">Call prices</th>
                        <th rowspan="2">SMS price</th>
                        <th colspan="3">Parameters</th>
                    </tr>
                    <tr style="background-color: yellow">
                        <td>Inside</td>
                        <td>Outside</td>
                        <td>Landline phone</td>
                        <td>Favorite numbers</td>
                        <td>Tariffing</td>
                        <td>Payment for connection</td>
                    </tr>
                    <xsl:for-each select="tariffs/tariff">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="operator_name"/></td>
                            <td><xsl:value-of select="payroll"/></td>
                            <td><xsl:value-of select="call_prices/inside"/></td>
                            <td><xsl:value-of select="call_prices/outside"/></td>
                            <td><xsl:value-of select="call_prices/landline_phone"/></td>
                            <td><xsl:value-of select="sms_price"/></td>
                            <td><xsl:value-of select="parameters/favorite_numbers"/></td>
                            <td><xsl:value-of select="parameters/tariffing"/></td>
                            <td><xsl:value-of select="parameters/connection_payment"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

