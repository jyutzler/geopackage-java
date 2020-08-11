package mil.nga.geopackage.attributes;

import java.sql.ResultSet;

import mil.nga.geopackage.db.GeoPackageConnection;
import mil.nga.geopackage.user.UserConnection;

/**
 * GeoPackage Attributes Connection
 * 
 * @author osbornb
 * @since 1.2.1
 */
public class AttributesConnection extends
		UserConnection<AttributesColumn, AttributesTable, AttributesRow, AttributesResultSet> {

	/**
	 * Constructor
	 * 
	 * @param database
	 *            GeoPackage connection
	 */
	public AttributesConnection(GeoPackageConnection database) {
		super(database);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected AttributesResultSet createResult(String[] columns,
			ResultSet resultSet, int count) {
		return new AttributesResultSet(table, columns, resultSet, count);
	}

	@Override
	public AttributesResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public AttributesResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public AttributesResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public AttributesResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String selection, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String selection, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public String querySQL(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String groupBy, String having, String orderBy, String limit) {
		return null;
	}
}
