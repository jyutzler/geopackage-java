package mil.nga.geopackage.features.user;

import java.sql.ResultSet;

import mil.nga.geopackage.db.GeoPackageConnection;
import mil.nga.geopackage.user.UserConnection;

/**
 * GeoPackage Feature Connection
 * 
 * @author osbornb
 */
public class FeatureConnection extends
		UserConnection<FeatureColumn, FeatureTable, FeatureRow, FeatureResultSet> {

	/**
	 * Constructor
	 * 
	 * @param database
	 *            GeoPackage connection
	 */
	public FeatureConnection(GeoPackageConnection database) {
		super(database);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected FeatureResultSet createResult(String[] columns,
			ResultSet resultSet, int count) {
		return new FeatureResultSet(table, columns, resultSet, count);
	}

	@Override
	public FeatureResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public FeatureResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
		return null;
	}

	@Override
	public FeatureResultSet query(boolean distinct, String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		return null;
	}

	@Override
	public FeatureResultSet query(boolean distinct, String table, String[] columns, String[] columnsAs, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
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
