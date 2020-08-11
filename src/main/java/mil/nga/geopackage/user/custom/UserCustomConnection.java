package mil.nga.geopackage.user.custom;

import java.sql.ResultSet;

import mil.nga.geopackage.db.GeoPackageConnection;
import mil.nga.geopackage.user.UserConnection;

/**
 * GeoPackage User Custom Connection
 * 
 * @author osbornb
 * @since 3.0.1
 */
public class UserCustomConnection extends
		UserConnection<UserCustomColumn, UserCustomTable, UserCustomRow, UserCustomResultSet> {

	/**
	 * Constructor
	 * 
	 * @param database
	 *            database connection
	 */
	public UserCustomConnection(GeoPackageConnection database) {
		super(database);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected UserCustomResultSet createResult(String[] columns,
			ResultSet resultSet, int count) {
		return new UserCustomResultSet(table, columns, resultSet, count);
	}

	@Override
	public UserCustomResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public UserCustomResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public UserCustomResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public UserCustomResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
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
